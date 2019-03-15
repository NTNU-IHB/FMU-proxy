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

#include <cstdio>
#include <string>

namespace {

    void write_data(std::string const &fileName, std::string const &data) {

        FILE *file = fopen(fileName.c_str(), "wb");
        size_t bytes_written = fwrite(data.c_str(), sizeof(unsigned char), data.size(), file);
        fclose(file);
    }

    void read_data(std::string const &fileName, std::string &data) {


        FILE *file = fopen(fileName.c_str(), "rb");
        if (file == NULL) return;
        fseek(file, 0, SEEK_END);
        long int size = ftell(file);
        fclose(file);
        file = fopen(fileName.c_str(), "rb");

        data.resize(size);
        size_t bytes_read = fread(data.data(), sizeof(unsigned char), size, file);
        fclose(file);

    }

}

#endif //FMU_PROXY_FILE_READER_HPP
