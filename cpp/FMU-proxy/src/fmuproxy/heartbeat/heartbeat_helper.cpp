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

#include <string>
#include <sstream>
#include <iomanip>
#include <cctype>
#include <algorithm>
#include <vector>
#include <boost/uuid/uuid_io.hpp>
#include <boost/uuid/uuid.hpp>
#include <boost/uuid/uuid_generators.hpp>
#include <boost/algorithm/string/join.hpp>
#include <curl/curl.h>
#include <fmuproxy/heartbeat/RemoteAddress.hpp>

using namespace std;
using namespace boost::uuids;

namespace fmuproxy::heartbeat {

    const string generate_uuid() {
        random_generator generator;
        uuid uuid = generator();
        return to_string(uuid);
    }

    //https://stackoverflow.com/questions/7724448/simple-json-string-escape-for-c
    const string toJSON(const std::string &s) {
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

    const string toJSON(vector<string> v) {
        return "[" + boost::algorithm::join(v, ", ") + "]";
    }

    // https://stackoverflow.com/questions/44994203/how-to-get-the-http-response-string-using-curl-in-c
    const size_t write_callback(char *contents, size_t size, size_t nmemb, void *userp) {
        ((std::string*)userp)->append(contents, size * nmemb);
        return size * nmemb;
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

    static inline CURLcode post(const RemoteAddress &remote, CURL *curl, string &response, const string &ctx, const string &data) {

        const string url = "http://" + remote.host + ":" + to_string(remote.port) + "/fmu-proxy/" + ctx;
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, data.c_str());

        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_callback);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);

        return curl_easy_perform(curl);

    }

}
