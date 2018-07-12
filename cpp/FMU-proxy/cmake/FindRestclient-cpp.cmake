# - CMake script for locating restclient-cpp (https://github.com/mrtazz/restclient-cpp)
#
#  LIBRESTCLIENT_CPP_FOUND - System has restclient-cpp
#  LIBRESTCLIENT_CPP_INCLUDE_DIRS - The restclient-cpp include directories
#  LIBRESTCLIENT_CPP_LIBRARIES - The libraries needed to use restclient-cpp
#  LIBRESTCLIENT_CPP_DEFINITIONS - Compiler switches required for using restclient-cpp

find_package(PkgConfig)
pkg_check_modules(PC_RESTCLIENT_CPP restclient-cpp)

include(FindPackageHandleStandardArgs)

mark_as_advanced(LIBRESTCLIENT_CPP_INCLUDE_DIR LIBRESTCLIENT_CPP_LIBRARY)

set(LIBRESTCLIENT_CPP_INCLUDE_DIRS ${LIBRESTCLIENT_CPP_INCLUDE_DIR})
set(LIBRESTCLIENT_CPP_LIBRARIES ${LIBRESTCLIENT_CPP_LIBRARY})