#!/usr/bin/env bash

conan remote add helmesjo "https://api.bintray.com/conan/helmesjo/public-conan" --f
conan remote add inexorgame "https://api.bintray.com/conan/inexorgame/inexor-conan" --f
conan remote add bincrafters "https://api.bintray.com/conan/bincrafters/public-conan" --f

unameOut="$(uname -s)"
case "${unameOut}" in
    MINGW*)     conan install . -s build_type=Debug --install-folder=cmake-build-debug --build=missing;;
    MINGW*)     conan install . -s build_type=Release --install-folder=cmake-build-release --build=missing;;
    Linux*)     conan install . -s build_type=Debug -s compiler.libcxx=libstdc++11 --install-folder=cmake-build-debug --build=missing;;
    Linux*)     conan install . -s build_type=Release -s compiler.libcxx=libstdc++11 --install-folder=cmake-build-release --build=missing;;
esac
