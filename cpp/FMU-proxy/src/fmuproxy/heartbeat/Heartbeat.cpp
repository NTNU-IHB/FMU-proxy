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
#include <chrono>
#include <memory>
#include <curl/curl.h>
#include <fmuproxy/heartbeat/Heartbeat.hpp>
#include <nlohmann/json.hpp>
#include "heartbeat_helper.cpp"

using namespace std;
using namespace fmuproxy;
using namespace fmuproxy::heartbeat;

using json = nlohmann::json;

Heartbeat::Heartbeat(const RemoteAddress remote, const map<string, unsigned int> &ports,
                     const vector<string> &modelDescriptions) : remote_(remote), ports_(ports), modelDescriptions_(modelDescriptions) {}

void Heartbeat::start() {
   thread_ = make_unique<thread>(&Heartbeat::run, this);
}

void Heartbeat::run() {

    CURL *curl;
    CURLcode res;

    curl_global_init(CURL_GLOBAL_ALL);
    curl = curl_easy_init();

    if (curl) {

        string uuid = generate_uuid();
        trim(uuid);

        json json = {
                {"uuid", uuid},
                {"ports", ports_},
                {"modelDescriptions", modelDescriptions_},

            };

        const string json_str = json.dump(2);

        while (!stop_) {

            if (connected_) {

                string response;
                res = post(remote_, curl, response, "ping", uuid);
                if (res != CURLE_OK) {
                    fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
                    connected_ = false;
                } else {
                    trim(response);
                    connected_ = response == "success";
                    if (!connected_) {
                        cout << "Disconnected from remote tracking server!" << endl;
                    }
                }

                this_thread::sleep_for(chrono::milliseconds(1000));

            } else {

                string response;
                res = post(remote_, curl, response, "register", json_str);
                if (res != CURLE_OK) {
                    fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
                } else {
                    trim(response);
                    connected_ = response == "success";
                    if (connected_) {
                        cout << "Connected to remote tracking server!" << endl;
                        continue;
                    }
                }

                this_thread::sleep_for(chrono::milliseconds(2500));

            }
        }

        curl_easy_cleanup(curl);

    }

    curl_global_cleanup();

}

void Heartbeat::stop() {
    stop_ = true;
    thread_->join();
}

