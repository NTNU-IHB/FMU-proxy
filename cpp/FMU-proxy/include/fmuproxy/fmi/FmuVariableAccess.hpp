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

#ifndef FMU_PROXY_FMUVARIABLEACCESS_HPP
#define FMU_PROXY_FMUVARIABLEACCESS_HPP

#include <fmilib.h>

class VariableReader {

private:
    fmi2_import_t *instance;
    const fmi2_value_reference_t vr;

public:
    VariableReader(fmi2_import_t *instance, fmi2_value_reference_t vr): instance(instance), vr(vr){}

    fmi2_status_t readInteger(fmi2_integer_t &value) {
        return fmi2_import_get_integer(instance, &vr, 1, &value);
    }

    fmi2_status_t readReal(fmi2_real_t &value) {
        return fmi2_import_get_real(instance, &vr, 1, &value);
    }

    fmi2_status_t readString(fmi2_string_t &value) {
        return fmi2_import_get_string(instance, &vr, 1, &value);
    }

    fmi2_status_t readBoolean(fmi2_boolean_t &value) {
        return fmi2_import_get_boolean(instance, &vr, 1, &value);
    }

};

class VariableWriter {

private:
    fmi2_import_t *instance;
    const fmi2_value_reference_t vr;

public:
    VariableWriter(fmi2_import_t *instance, fmi2_value_reference_t vr): instance(instance), vr(vr){}

    fmi2_status_t writeInteger(fmi2_integer_t value) {
        return fmi2_import_set_integer(instance, &vr, 1, &value);
    }

    fmi2_status_t writeReal(fmi2_real_t value) {
        return fmi2_import_set_real(instance, &vr, 1, &value);
    }

    fmi2_status_t writeString(fmi2_string_t value) {
        return fmi2_import_set_string(instance, &vr, 1, &value);
    }

    fmi2_status_t writeBoolean(fmi2_boolean_t value) {
        return fmi2_import_set_boolean(instance, &vr, 1, &value);
    }

};


#endif //FMU_PROXY_FMUVARIABLEACCESS_HPP
