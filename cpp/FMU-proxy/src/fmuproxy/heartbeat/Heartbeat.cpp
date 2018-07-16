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
#include <sstream>
#include <iomanip>

#include <curl/curl.h>
#include <fmuproxy/heartbeat/Heartbeat.hpp>

#include <boost/uuid/uuid.hpp>
#include <boost/uuid/uuid_generators.hpp>
#include <boost/uuid/uuid_io.hpp>

using namespace std;
using namespace boost::uuids;
using namespace fmuproxy::heartbeat;

namespace {

    const string generate_uuid() {
        random_generator generator;
        uuid uuid = generator();
        return to_string(uuid);
    }

    //https://stackoverflow.com/questions/7724448/simple-json-string-escape-for-c
    string escape_json(const std::string &s) {
        std::ostringstream o;
        for (auto c = s.cbegin(); c != s.cend(); c++) {
            if (*c == '"' || *c == '\\' || ('\x00' <= *c && *c <= '\x1f')) {
                o << "\\u"
                  << std::hex << std::setw(4) << std::setfill('0') << (int)*c;
            } else {
                o << *c;
            }
        }
        return o.str();
    }

    //https://stackoverflow.com/questions/15571922/putting-curl-result-in-a-string-and-not-stdout
    int http_get_response(void *buffer, size_t size, size_t rxed, char **msg_in)
    {
        char *c;

        if (asprintf(&c, "%s%.*s", *msg_in, size * rxed, buffer) == -1) {
            free(*msg_in);
            msg_in = NULL;
            return -1;
        }

        free(*msg_in);
        *msg_in = c;

        return size * rxed;
    }


    //https://stackoverflow.com/questions/216823/whats-the-best-way-to-trim-stdstring
    // trim from start (in place)
    static inline void ltrim(string &s) {
        s.erase(s.begin(), std::find_if(s.begin(), s.end(), [](int ch) {
            return !std::isspace(ch);
        }));
    }

    //https://stackoverflow.com/questions/216823/whats-the-best-way-to-trim-stdstring
    // trim from end (in place)
    static inline void rtrim(string &s) {
        s.erase(std::find_if(s.rbegin(), s.rend(), [](int ch) {
            return !std::isspace(ch);
        }).base(), s.end());
    }

    //https://stackoverflow.com/questions/216823/whats-the-best-way-to-trim-stdstring
    // trim from both ends (in place)
    static inline void trim(string &s) {
        ltrim(s);
        rtrim(s);
    }

}


Heartbeat::Heartbeat(const string &host, const unsigned int port, const string &xml)
        : host(host), port(port), model_description_xml(escape_json(xml)) {}

void Heartbeat::start() {
   m_thread = new thread(&Heartbeat::run, this);
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

                char *response = new char();

                string url = "http://" + host + ":" + to_string(port) + "/fmu-proxy/ping";
                curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
                curl_easy_setopt(curl, CURLOPT_POSTFIELDS, uuid.c_str());

                curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, http_get_response);
                curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);

                res = curl_easy_perform(curl);
                /* Check for errors */
                if (res != CURLE_OK) {
                    fprintf(stderr, "curl_easy_perform() failed: %s\n",
                            curl_easy_strerror(res));
                } else {
                    string _response = string(response);
                    trim(_response);
                    m_connected = _response == "success";
                    delete response;
                    if (!m_connected) {
                        cout << "Disconnected from remote tracking server!" << endl;
                    }

                }

                usleep(1 * 100000); // 100msec

            } else {

                char *response = new char();

                string url = "http://" + host + ":" + to_string(port) + "/fmu-proxy/registerfmu";
                curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
                curl_easy_setopt(curl, CURLOPT_POSTFIELDS, json.c_str());

                curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, http_get_response);
                curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);

                res = curl_easy_perform(curl);

                /* Check for errors */
                if (res != CURLE_OK) {
                    fprintf(stderr, "curl_easy_perform() failed: %s\n",
                            curl_easy_strerror(res));
                } else {
                    string _response = string(response);
                    trim(_response);
                    m_connected = _response == "success";
                    delete response;
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

Heartbeat::~Heartbeat() {
    delete m_thread;
}
