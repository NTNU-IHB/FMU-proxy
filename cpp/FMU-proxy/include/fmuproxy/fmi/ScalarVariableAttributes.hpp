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

#ifndef FMU_PROXY_SCALARVARIABLEATTRIBUTES_HPP
#define FMU_PROXY_SCALARVARIABLEATTRIBUTES_HPP

#include <iostream>
#include <string>

namespace fmuproxy { namespace fmi {

    class IntegerAttribute {
    private:
        int min;
        int max;
        int start;
        bool start_set = false;
        bool min_set = false;
        bool max_set = false;
    public:

        int getMin() const {
            return min;
        }

        void setMin(int min) {
            this->min = min;
            this->min_set = true;
        }

        int getMax() const {
            return max;
        }

        void setMax(int max) {
            this->max = max;
            this->max_set = true;
        }

        int getStart() const {
            return start;
        }

        void setStart(int start) {
            this->start = start;
            this->start_set = true;
        }

        bool isStart_set() const {
            return start_set;
        }

        bool isMin_set() const {
            return min_set;
        }

        bool isMax_set() const {
            return max_set;
        }

        friend std::ostream& operator<<(std::ostream &strm, const IntegerAttribute &a) {
            return strm << "IntegerAttribute(start=" << a.getStart() << ", min=" << a.getMin() << ", max=" << a.getMax() << ")";
        }

    };

    class RealAttribute {
    private:
        double min;
        double max;
        double start;
        bool start_set = false;
        bool min_set = false;
        bool max_set = false;
    public:

        double getMin() const {
            return min;
        }

        double getMax() const {
            return max;
        }

        double getStart() const {
            return start;
        }

        void setStart(const double value) {
            this->start = value;
            this-> start_set = true;
        }

        void setMin(const double value) {
            this->min = value;
            this-> min_set = true;
        }

        void setMax(const double value) {
            this->max = value;
            this-> max_set = true;
        }

        bool isStart_set() const {
            return start_set;
        }

        bool isMin_set() const {
            return min_set;
        }

        bool isMax_set() const {
            return max_set;
        }

        friend std::ostream& operator<<(std::ostream &strm, const RealAttribute &a) {
            return strm << "RealAttribute(start=" << a.getStart() << ", min=" << a.getMin() << ", max=" << a.getMax() << ")";
        }

    };

    class StringAttribute {
    private:
        std::string start;
        bool start_set = false;
    public:

        void setStart(const std::string &start) {
            this->start = start;
            this->start_set = true;
        }

        const std::string &getStart() const {
            return start;
        }

        bool isStart_set() const {
            return start_set;
        }

        friend std::ostream& operator<<(std::ostream &strm, const StringAttribute &a) {
            return strm << "StringAttribute(start=" << a.getStart() << ")";
        }

    };

    class BooleanAttribute {
    private:
        bool start;
        bool start_set = false;
    public:

        bool getStart() const {
            return start;
        }

        void setStart(bool start) {
            this->start = start;
            this->start_set = true;
        }

        bool isStart_set() const {
            return start_set;
        }

        friend std::ostream& operator<<(std::ostream &strm, const BooleanAttribute &a) {
            return strm << "BooleanAttribute(start=" << (a.getStart() != 0) << ")";
        }


    };

    class EnumerationAttribute {
    private:
        int min;
        int max;
        int start;
        bool start_set = false;
        bool min_set = false;
        bool max_set = false;
    public:

        int getMin() const {
            return min;
        }

        void setMin(int min) {
            this->min = min;
            this->min_set = true;
        }

        int getMax() const {
            return max;
        }

        void setMax(int max) {
            this->max = max;
            this->max_set = true;
        }

        int getStart() const {
            return start;
        }

        void setStart(int start) {
            this->start = start;
            this->start_set = true;
        }

        bool isStart_set() const {
            return start_set;
        }

        bool isMin_set() const {
            return min_set;
        }

        bool isMax_set() const {
            return max_set;
        }

        friend std::ostream& operator<<(std::ostream &strm, const EnumerationAttribute &a) {
            return strm << "EnumerationAttribute(start=" << a.getStart() << ", min=" << a.getMin() << ", max=" << a.getMax() << ")";
        }

    };


    class ScalarVariableAttribute {
    private:
        bool integer_set = false;
        bool real_set = false;
        bool string_set = false;
        bool boolean_set = false;
        bool enumeration_set = false;

        IntegerAttribute integerAttribute;
        RealAttribute realAttribute;
        StringAttribute stringAttribute;
        BooleanAttribute booleanAttribute ;
        EnumerationAttribute enumerationAttribute;

    public:

        bool isIntegerAttribute() const {
            return integer_set;
        }

        bool isRealAttribute() const {
            return real_set;
        }

        bool isStringAttribute() const {
            return string_set;
        }

        bool isBooleanAttribute() const {
            return boolean_set;
        }

        bool isEnumerationAttribute() const {
            return enumeration_set;
        }

        const IntegerAttribute &getIntegerAttribute() const {
            return integerAttribute;
        }

        const RealAttribute &getRealAttribute() const {
            return realAttribute;
        }

        const StringAttribute &getStringAttribute() const {
            return stringAttribute;
        }

        const BooleanAttribute &getBooleanAttribute() const {
            return booleanAttribute;
        }

        const EnumerationAttribute &getEnumerationAttribute() const {
            return enumerationAttribute;
        }

        void setIntegerAttribute(const IntegerAttribute &integerAttribute) {
            ScalarVariableAttribute::integerAttribute = integerAttribute;
            integer_set = true;
        }

        void setRealAttribute(const RealAttribute &realAttribute) {
            ScalarVariableAttribute::realAttribute = realAttribute;
            real_set = true;
        }

        void setStringAttribute(const StringAttribute &stringAttribute) {
            ScalarVariableAttribute::stringAttribute = stringAttribute;
            string_set = true;
        }

        void setBooleanAttribute(const BooleanAttribute &booleanAttribute) {
            ScalarVariableAttribute::booleanAttribute = booleanAttribute;
            boolean_set = true;
        }

        void setEnumerationAttribute(const EnumerationAttribute &enumerationAttribute) {
            ScalarVariableAttribute::enumerationAttribute = enumerationAttribute;
            enumeration_set = true;
        }

        friend std::ostream& operator<<(std::ostream &strm, const ScalarVariableAttribute &a) {

            if (a.isIntegerAttribute()) {
                auto _a = a.getIntegerAttribute();
                return strm << "IntegerAttribute(start=" << _a.getStart() << ", min=" << _a.getMin() << ", max=" << _a.getMax() << ")";
            } else if (a.isRealAttribute()) {
                auto _a = a.getRealAttribute();
                return strm << "RealAttribute(start=" << _a.getStart() << ", min=" << _a.getMin() << ", max=" << _a.getMax() << ")";
            } else if  (a.isStringAttribute()) {
                const auto &_a = a.getStringAttribute();
                return strm << "StringAttribute(start=" << _a.getStart() << ")";
            } else if (a.isBooleanAttribute()) {
                auto _a = a.getBooleanAttribute();
                return strm << "BooleanAttribute(start=" << _a.getStart() << ")";
            } else if (a.isEnumerationAttribute()) {
                auto _a = a.getEnumerationAttribute();
                return strm << "EnumerationAttribute(start=" << _a.getStart() << ", min=" << _a.getMin() << ", max=" << _a.getMax() << ")";
            } else {
                throw std::runtime_error("no valid attribute set!");
            }

        }

    };

}}

#endif //FMU_PROXY_SCALARVARIABLEATTRIBUTES_HPP
