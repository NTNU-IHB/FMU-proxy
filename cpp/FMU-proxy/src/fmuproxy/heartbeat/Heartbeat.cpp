/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

#include <iostream>
#include <curl/curl.h>
#include <fmuproxy/heartbeat/Heartbeat.hpp>

#include "heartbeat_helper.cpp"

using namespace std;
using namespace fmuproxy::heartbeat;

Heartbeat::Heartbeat(const string &host, const unsigned int port, const string &xml)
        : host(host), port(port), model_description_xml(escape_json(xml)) {}

void Heartbeat::start() {
   m_thread = unique_ptr<thread>(new thread(&Heartbeat::run, this));
}

void Heartbeat::run() {

    CURL *curl;
    CURLcode res;

    curl_global_init(CURL_GLOBAL_ALL);
    curl = curl_easy_init();

    if (curl) {

        string uuid = generate_uuid();
        trim(uuid);

        string json = "{\n"
                      "  \"uuid\": \"" + uuid + "\",\n"
                      "  \"modelDescriptionXml\": \"" + model_description_xml + "\",\n"
                      "  \"networkInfo\": {\n"
                      "    \"host\": \"localhost\",\n"
                      "    \"ports\": {\n"
                      "      \"thrift/tcp\": 9090\n"
                      "    }\n"
                      "  }\n"
                      "}";

        while (!m_stop) {

            if (m_connected) {

                std::string response;
                res = post(host, port, curl, response, "ping", uuid.c_str());
                if (res != CURLE_OK) {
                    fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
                    m_connected = false;
                } else {
                    trim(response);
                    m_connected = response == "success";
                    if (!m_connected) {
                        cout << "Disconnected from remote tracking server!" << endl;
                    }
                }

                usleep(1 * 100000); // 100msec

            } else {

                std::string response;
                res = post(host, port, curl, response, "registerfmu", json.c_str());
                if (res != CURLE_OK) {
                    fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
                } else {
                    trim(response);
                    m_connected = response == "success";
                    if (m_connected) {
                        cout << "Connected to remote tracking server!" << endl;
                        continue;
                    }
                }

                usleep(1 * 1000000); // 1000msec

            }
        }

        curl_easy_cleanup(curl);

    }

    curl_global_cleanup();

}

void Heartbeat::stop() {
    m_stop = true;
    m_thread->join();
}

