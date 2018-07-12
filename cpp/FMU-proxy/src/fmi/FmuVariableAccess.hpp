//
// Created by laht on 12.07.18.
//

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
