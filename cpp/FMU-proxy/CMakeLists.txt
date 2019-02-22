
option(FMU_PROXY_BUILD_TESTS "Build tests" OFF)
option(FMU_PROXY_BUILD_EXAMPLES "Build examples" ON)
option(FMU_PROXY_BUILD_TOOL "Build the server executable" ON)
option(FMU_PROXY_WITH_GRPC "Build with gRPC support" ON)
option(FMU_PROXY_WITH_THRIFT "Build with Thrift support" ON)
option(FMU_PROXY_USING_VCPKG "Build using vcpkg" OFF)
option(FMU_PROXY_USING_CONAN "Build using conan" OFF)

if (FMU_PROXY_USING_VCPKG AND FMU_PROXY_USING_CONAN)
    message(FATAL_ERROR "Cannot use both vcpkg and conan!")
endif()

if(NOT FMU_PROXY_USING_VCPKG)
    set(CMAKE_TOOLCHAIN_FILE "")
endif()

cmake_minimum_required(VERSION 3.10)
project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

if (FMU_PROXY_USING_CONAN)
    if(EXISTS ${CMAKE_BINARY_DIR}/conanbuildinfo.cmake)
        include(${CMAKE_BINARY_DIR}/conanbuildinfo.cmake)
        conan_basic_setup()
    else()
        message(FATAL_ERROR "The file conanbuildinfo.cmake doesn't exist, you have to run conan install first!")
    endif()

endif()

if(MSVC)
    set(CMAKE_DEBUG_POSTFIX "d")
    add_definitions("-DNOMINMAX" "-D_WIN32_WINNT=0x600" "-D_CRT_SECURE_NO_WARNINGS")
    add_compile_options("/wd4996" "/wd4251")
endif()

if (FMU_PROXY_BUILD_TESTS)
    list(APPEND BOOST_COMPONENTS unit_test_framework)
endif()
if (FMU_PROXY_BUILD_TOOL)
    list(APPEND BOOST_COMPONENTS program_options)
endif()

find_package(Boost 1.65 COMPONENTS ${BOOST_COMPONENTS} REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

find_package(JSON REQUIRED)
find_package(CURL REQUIRED)

if (FMU_PROXY_WITH_THRIFT)
    find_package(Thrift REQUIRED)
    if (NOT FMU_PROXY_USING_CONAN)
        find_package(Libevent CONFIG REQUIRED)
    endif()
    add_definitions(-DFMU_PROXY_WITH_THRIFT)
endif()

if (FMU_PROXY_WITH_GRPC)
    find_package(Protobuf REQUIRED)
    find_package(gRPC CONFIG REQUIRED)
    add_definitions(-DFMU_PROXY_WITH_GRPC)
endif()

# add subdiretories
option(FMI4CPP_BUILD_EXAMPLES "" OFF)
option(FMI4CPP_BUILD_TESTS "" OFF)
option(FMI4CPP_BUILD_TOOL "" OFF)
option(FMI4CPP_WITH_ODEINT "" ON)
option(FMI4CPP_WITH_CURL "" ON)
option(FMI4CPP_USING_VCPKG "" ${FMU_PROXY_USING_VCPKG})
option(FMI4CPP_USING_CONAN "" ${FMU_PROXY_USING_CONAN})
add_subdirectory(FMI4cpp)

add_subdirectory(src)


if (FMU_PROXY_BUILD_TESTS OR FMU_PROXY_BUILD_EXAMPLES)
    file(COPY ../../test/fmus DESTINATION ${CMAKE_CURRENT_BINARY_DIR})

    if (FMU_PROXY_BUILD_TESTS)
        add_subdirectory(tests)
    endif()

    if (FMU_PROXY_BUILD_EXAMPLES)
        add_subdirectory(examples)
    endif()

endif()

if (FMU_PROXY_BUILD_TOOL)
    add_subdirectory(tool)
endif()