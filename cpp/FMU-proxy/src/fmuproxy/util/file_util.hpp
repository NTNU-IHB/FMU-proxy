/*
 * The MIT License
 *
 * Copyright 2017-2019 Norwegian University of Technology
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

#ifndef FMU_PROXY_FILE_READER_HPP
#define FMU_PROXY_FILE_READER_HPP

#include <string>
#include <fstream>

namespace {

    void readData(const std::string &file, std::string &data) {
        std::ifstream input(file, std::ios::out | std::ios::binary);

        size_t len = 0;
        input.read((char*) &len, sizeof(len));
        data.resize(len);
        input.read(&data[0], len);
    }

    void writeData(const std::string &file, const std::string &data) {
            std::ofstream input(file, std::ios::out | std::ios::binary);

            size_t len = data.size();
            input.write((char*) &len, sizeof(len));
            input.write(&data[0], len);
    }
    
}

#endif //FMU_PROXY_FILE_READER_HPP
