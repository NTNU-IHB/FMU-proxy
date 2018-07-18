cmake_minimum_required(VERSION 3.10)
project(FMU_PROXY)

set(CMAKE_CXX_STANDARD 17)

list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/cmake")

find_package(Boost 1.65.1 COMPONENTS system filesystem program_options REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})
link_directories(${Boost_LIBRARY_DIRS})

find_package(FMILIB REQUIRED)
include_directories(${FMILIB_INCLUDE_DIRS})
link_libraries(${FMILIB_LIBRARIES})

find_package(CURL REQUIRED)
include_directories(${CURL_INCLUDE_DIRS})
link_libraries(${CURL_LIBRARIES})

# add subdiretories
add_subdirectory(src)
add_subdirectory(tool)
add_subdirectory(example)
