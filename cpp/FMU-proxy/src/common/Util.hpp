//
// Created by laht on 19.06.18.
//

#ifndef FMU_PROXY_UTIL_H
#define FMU_PROXY_UTIL_H


std::string getOs() {
#ifdef _WIN32
    return "win64";
#elif __linux__
    return "linux64";
#endif
}

#endif //FMU_PROXY_UTIL_H
