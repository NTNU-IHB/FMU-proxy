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

#ifndef FMU_PROXY_REMOTEADDRESS_HPP
#define FMU_PROXY_REMOTEADDRESS_HPP

#include <string>
#include <vector>
#include <boost/algorithm/string.hpp>
#include <ostream>

namespace fmuproxy {

    class RemoteAddress {

    public:

        const std::string host;
        const unsigned int port;

        RemoteAddress(const std::string &host, const unsigned int port)
                : host(host), port(port) {}

        static RemoteAddress parse(std::string &address) {
            std::vector<std::string> split;
            boost::split(split, address, boost::is_any_of(":"));
            const std::string host = split[0];
            const int port = std::stoi(split[1]);
            return RemoteAddress(host, port);
        }

        friend std::ostream& operator<<(std::ostream &strm, const RemoteAddress &a) {
            return strm << "RemoteAddress(" << a.host << ":" << a.port << ")";
        }

    };

}

#endif //FMU_PROXY_REMOTEADDRESS_HPP
