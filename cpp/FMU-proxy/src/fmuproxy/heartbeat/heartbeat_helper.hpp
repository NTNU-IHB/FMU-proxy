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

#ifndef FMU_PROXY_HEARTBEAT_HELPER_HPP
#define FMU_PROXY_HEARTBEAT_HELPER_HPP

#include <string>
#include <sstream>
#include <iomanip>
#include <vector>
#include <random>
#include <cctype>
#include <locale>
#include <algorithm>

#include <curl/curl.h>
#include <boost/algorithm/string/join.hpp>

#include <fmuproxy/heartbeat/remote_address.hpp>


namespace {
    
    // trim from start (in place)
    inline void ltrim(std::string &s) {
        s.erase(s.begin(), std::find_if(s.begin(), s.end(), [](int ch) {
            return !std::isspace(ch);
        }));
    }

    // trim from end (in place)
    inline void rtrim(std::string &s) {
        s.erase(std::find_if(s.rbegin(), s.rend(), [](int ch) {
            return !std::isspace(ch);
        }).base(), s.end());
    }

    // trim from both ends (in place)
    inline void trim(std::string &s) {
        ltrim(s);
        rtrim(s);
    }

    //https://stackoverflow.com/questions/7724448/simple-json-string-escape-for-c
    inline std::string to_JSON(const std::string &s) {
        std::ostringstream o;
        for (auto c = s.cbegin(); c != s.cend(); c++) {
            if (*c == '"' || *c == '\\' || ('\x00' <= *c && *c <= '\x1f')) {
                o << "\\u"
                  << std::hex << std::setw(4) << std::setfill('0') << (int) *c;
            } else {
                o << *c;
            }
        }
        return o.str();
    }

    inline std::string toJSON(std::vector<std::string> v) {
        return "[" + boost::algorithm::join(v, ", ") + "]";
    }

    // https://stackoverflow.com/questions/44994203/how-to-get-the-http-response-string-using-curl-in-c
    inline size_t write_callback(char *contents, size_t size, size_t nmemb, void *userp) {
        ((std::string *) userp)->append(contents, size * nmemb);
        return size * nmemb;
    }

    inline CURLcode post(const fmuproxy::remote_address &remote, CURL *curl, std::string &response, const std::string &ctx,
                         const std::string &data) {

        const std::string url = "http://" + remote.host + ":" + std::to_string(remote.port) + "/fmu-proxy/" + ctx;
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, data.c_str());

        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_callback);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);

        return curl_easy_perform(curl);

    }

}

#endif //FMU_PROXY_HEARTBEAT_HELPER_HPP
