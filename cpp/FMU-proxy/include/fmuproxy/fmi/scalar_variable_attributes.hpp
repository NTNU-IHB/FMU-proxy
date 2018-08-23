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

namespace fmuproxy::fmi {

    class IntegerAttribute {
    private:
        int min_;
        int max_;
        int start_;
        bool isStartSet_ = false;
        bool isMinSet_ = false;
        bool isMaxSet_ = false;
    public:

        int getMin() const {
            return min_;
        }

        void setMin(int min) {
            this->min_ = min;
            this->isMinSet_ = true;
        }

        int getMax() const {
            return max_;
        }

        void setMax(int max) {
            this->max_ = max;
            this->isMaxSet_ = true;
        }

        int getStart() const {
            return start_;
        }

        void setStart(int start) {
            this->start_ = start;
            this->isStartSet_ = true;
        }

        bool isStart_set() const {
            return isStartSet_;
        }

        bool isMin_set() const {
            return isMinSet_;
        }

        bool isMax_set() const {
            return isMaxSet_;
        }

        friend std::ostream& operator<<(std::ostream &strm, const IntegerAttribute &a) {
            return strm << "IntegerAttribute(start=" << a.getStart() << ", min=" << a.getMin() << ", max=" << a.getMax() << ")";
        }

    };

    class RealAttribute {
    private:
        double min_;
        double max_;
        double start_;
        bool isStartSet_ = false;
        bool isMinSet_ = false;
        bool isMaxSet_ = false;
    public:

        double getMin() const {
            return min_;
        }

        double getMax() const {
            return max_;
        }

        double getStart() const {
            return start_;
        }

        void setStart(const double value) {
            this->start_ = value;
            this-> isStartSet_ = true;
        }

        void setMin(const double value) {
            this->min_ = value;
            this-> isMinSet_ = true;
        }

        void setMax(const double value) {
            this->max_ = value;
            this-> isMaxSet_ = true;
        }

        bool isStart_set() const {
            return isStartSet_;
        }

        bool isMin_set() const {
            return isMinSet_;
        }

        bool isMax_set() const {
            return isMaxSet_;
        }

        friend std::ostream& operator<<(std::ostream &strm, const RealAttribute &a) {
            return strm << "RealAttribute(start=" << a.getStart() << ", min=" << a.getMin() << ", max=" << a.getMax() << ")";
        }

    };

    class StringAttribute {
    private:
        std::string start_;
        bool isStartSet_ = false;
    public:

        void setStart(const std::string &start) {
            this->start_ = start;
            this->isStartSet_ = true;
        }

        const std::string &getStart() const {
            return start_;
        }

        bool isStart_set() const {
            return isStartSet_;
        }

        friend std::ostream& operator<<(std::ostream &strm, const StringAttribute &a) {
            return strm << "StringAttribute(start=" << a.getStart() << ")";
        }

    };

    class BooleanAttribute {
    private:
        bool start_;
        bool isStartSet_ = false;
    public:

        bool getStart() const {
            return start_;
        }

        void setStart(bool start) {
            this->start_ = start;
            this->isStartSet_ = true;
        }

        bool isStart_set() const {
            return isStartSet_;
        }

        friend std::ostream& operator<<(std::ostream &strm, const BooleanAttribute &a) {
            return strm << "BooleanAttribute(start=" << (a.getStart() != 0) << ")";
        }


    };

    class EnumerationAttribute {
    private:
        int min_;
        int max_;
        int start_;
        bool isStartSet = false;
        bool isMinSet = false;
        bool isMaxSet = false;
    public:

        int getMin() const {
            return min_;
        }

        void setMin(int min) {
            this->min_ = min;
            this->isMinSet = true;
        }

        int getMax() const {
            return max_;
        }

        void setMax(int max) {
            this->max_ = max;
            this->isMaxSet = true;
        }

        int getStart() const {
            return start_;
        }

        void setStart(int start) {
            this->start_ = start;
            this->isStartSet = true;
        }

        bool isStart_set() const {
            return isStartSet;
        }

        bool isMin_set() const {
            return isMinSet;
        }

        bool isMax_set() const {
            return isMaxSet;
        }

        friend std::ostream& operator<<(std::ostream &strm, const EnumerationAttribute &a) {
            return strm << "EnumerationAttribute(start=" << a.getStart() << ", min=" << a.getMin() << ", max=" << a.getMax() << ")";
        }

    };


    class ScalarVariableAttribute {
    private:
        bool isIntegerSet_ = false;
        bool isRealSet_ = false;
        bool isStringSet_ = false;
        bool isBooleanSet_ = false;
        bool isEnumerationSet_ = false;

        IntegerAttribute integerAttribute_;
        RealAttribute realAttribute_;
        StringAttribute stringAttribute_;
        BooleanAttribute booleanAttribute_ ;
        EnumerationAttribute enumerationAttribute_;

    public:

        bool isIntegerAttribute() const {
            return isIntegerSet_;
        }

        bool isRealAttribute() const {
            return isRealSet_;
        }

        bool isStringAttribute() const {
            return isStringSet_;
        }

        bool isBooleanAttribute() const {
            return isBooleanSet_;
        }

        bool isEnumerationAttribute() const {
            return isEnumerationSet_;
        }

        const IntegerAttribute &getIntegerAttribute() const {
            return integerAttribute_;
        }

        const RealAttribute &getRealAttribute() const {
            return realAttribute_;
        }

        const StringAttribute &getStringAttribute() const {
            return stringAttribute_;
        }

        const BooleanAttribute &getBooleanAttribute() const {
            return booleanAttribute_;
        }

        const EnumerationAttribute &getEnumerationAttribute() const {
            return enumerationAttribute_;
        }

        void setIntegerAttribute(const IntegerAttribute &integerAttribute) {
            ScalarVariableAttribute::integerAttribute_ = integerAttribute;
            isIntegerSet_ = true;
        }

        void setRealAttribute(const RealAttribute &realAttribute) {
            ScalarVariableAttribute::realAttribute_ = realAttribute;
            isRealSet_ = true;
        }

        void setStringAttribute(const StringAttribute &stringAttribute) {
            ScalarVariableAttribute::stringAttribute_ = stringAttribute;
            isStringSet_ = true;
        }

        void setBooleanAttribute(const BooleanAttribute &booleanAttribute) {
            ScalarVariableAttribute::booleanAttribute_ = booleanAttribute;
            isBooleanSet_ = true;
        }

        void setEnumerationAttribute(const EnumerationAttribute &enumerationAttribute) {
            ScalarVariableAttribute::enumerationAttribute_ = enumerationAttribute;
            isEnumerationSet_ = true;
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

}

#endif //FMU_PROXY_SCALARVARIABLEATTRIBUTES_HPP
