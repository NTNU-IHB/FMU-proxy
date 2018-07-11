//
// Created by laht on 11.07.18.
//

#ifndef FMU_PROXY_TESTUTIL_HPP
#define FMU_PROXY_TESTUTIL_HPP

#include <iostream>

std::string getOs() {
#ifdef _WIN32
    return "win32";
#ielif _WIN64
    return "win64";
#elif __linux__
    return "linux64";
#endif
}

#endif //FMU_PROXY_TESTUTIL_HPP
