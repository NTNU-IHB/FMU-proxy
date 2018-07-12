//
// Created by laht on 12.07.18.
//

#ifndef FMU_PROXY_FMISIMULATION_HPP
#define FMU_PROXY_FMISIMULATION_HPP

#include <iostream>

namespace fmuproxy::fmi {

    class FmiSimulation {

    public:

        virtual double getCurrentTime() = 0;

        virtual bool isTerminated() = 0;

        virtual void init(double start, double stop) = 0;

        virtual fmi2_status_t step(double step_size) = 0;

        virtual fmi2_status_t reset() = 0;

        virtual fmi2_status_t terminate() = 0;

        virtual fmi2_status_t getInteger(unsigned int vr, int &ref) = 0;

        virtual fmi2_status_t getInteger(std::string name, int &ref) = 0;

        virtual fmi2_status_t getReal(unsigned int vr, double &ref) = 0;

        virtual fmi2_status_t getReal(std::string name, double &ref) = 0;

        virtual fmi2_status_t getString(unsigned int vr, const char* &ref) = 0;

        virtual fmi2_status_t getString(std::string name, const char* &ref) = 0;

        virtual fmi2_status_t getBoolean(unsigned int vr, int &ref) = 0;

        virtual fmi2_status_t getBoolean(std::string name, int &ref) = 0;

    };

}

#endif //FMU_PROXY_FMISIMULATION_HPP
