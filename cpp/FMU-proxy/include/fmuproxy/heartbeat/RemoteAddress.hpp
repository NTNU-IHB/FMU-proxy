//
// Created by LarsIvar on 23.08.2018.
//

#ifndef FMU_PROXY_REMOTEADdRESS_HPP
#define FMU_PROXY_REMOTEADdRESS_HPP

#include <string>
#include <vector>
#include <boost/algorithm/string.hpp>

namespace fmuproxy {

    struct RemoteAddress {

        inline RemoteAddress(const std::string host, const unsigned int port)
            : host(host), port(port) {}

        const std::string host;
        const unsigned int port;

        static RemoteAddress parse(std::string &address) {
            std::vector<std::string> split;
            boost::split(split, address, boost::is_any_of(":"));
            const std::string host = split[0];
            const unsigned int port = std::stoi(split[1]);
            return RemoteAddress(host, port);
        }

    };

}

#endif //FMU_PROXY_REMOTEADdRESS_HPP
