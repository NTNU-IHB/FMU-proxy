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
#include <fmilib.h>
#include "../thrift-gen/definitions_types.h"

using namespace fmuproxy::thrift;

namespace {

    fmi2_status_t convert(Status::type status) {

        switch (status) {
            case Status::OK_STATUS:
                return fmi2_status_ok;
            case Status::WARNING_STATUS:
                return fmi2_status_warning;
            case Status::DISCARD_STATUS:
                return fmi2_status_discard;
            case Status::ERROR_STATUS:
                return fmi2_status_error;
            case Status::FATAL_STATUS:
                return fmi2_status_fatal;
            case Status::PENDING_STATUS:
                return fmi2_status_pending;
            default:
                throw std::runtime_error("not a valid status: " + status);
        }

    }

}