
option(FMU_PROXY_BUILD_EXAMPLES "Build examples" ON)
option(FMU_PROXY_BUILD_TOOL "Build the server executable" ON)
option(FMU_PROXY_WITH_GRPC "Build with gRPC support" ON)
option(FMU_PROXY_WITH_THRIFT "Build with Thrift support" ON)

cmake_minimum_required(VERSION 3.11)
project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

if(EXISTS ${CMAKE_BINARY_DIR}/conanbuildinfo.cmake)
    include(${CMAKE_BINARY_DIR}/conanbuildinfo.cmake)
    conan_basic_setup()
else()
    message(FATAL_ERROR "The file conanbuildinfo.cmake doesn't exist, you have to run conan install first!")
endif()

add_compile_definitions(BOOST_CONFIG_SUPPRESS_OUTDATED_MESSAGE)

if(MSVC)
    set(CMAKE_DEBUG_POSTFIX "d")
    add_definitions("-DNOMINMAX" "-D_WIN32_WINNT=0x600" "-D_CRT_SECURE_NO_WARNINGS")
    add_compile_options("/wd4996" "/wd4251" "/wd4244" "/wd4267")
endif()

set(BOOST_COMPONENTS filesystem)

if (FMU_PROXY_BUILD_TOOL)
    list(APPEND BOOST_COMPONENTS program_options)
endif()

find_package(Boost 1.66 COMPONENTS ${BOOST_COMPONENTS} REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

if (FMU_PROXY_WITH_THRIFT)
    find_package(THRIFT REQUIRED)
endif()

if (FMU_PROXY_WITH_GRPC)
    find_package(OpenSSL COMPONENTS SSL REQUIRED)
    find_package(Protobuf REQUIRED)
    find_package(gRPC CONFIG REQUIRED)
endif()

# add subdiretories
add_subdirectory(FMI4cpp)

add_subdirectory(src)

if (FMU_PROXY_BUILD_EXAMPLES)
    file(COPY ../../test/fmus DESTINATION ${CMAKE_CURRENT_BINARY_DIR})

    if (FMU_PROXY_BUILD_EXAMPLES)
        add_subdirectory(examples)
    endif()

endif()

if (FMU_PROXY_BUILD_TOOL)
    add_subdirectory(tool)
endif()
