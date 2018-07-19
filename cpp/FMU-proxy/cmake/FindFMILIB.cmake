# Find FMI Library
#
# Find the native FMI Library headers and libraries.
#
#   FMILIB_INCLUDE_DIRS   - where to find fmilib.h
#   FMILIB_LIBRARIES      - List of libraries when using FMI Library.
#   FMILIB_FOUND          - True if FMI Library found.

cmake_minimum_required (VERSION 3.10)

find_path(FMILIB_INCLUDE_DIR NAMES
        fmilib.h
        PATHS
        ${FMILIB_HOME}/include)
mark_as_advanced(FMILIB_INCLUDE_DIR)

if (FMILIB_USE_SHARED_LIB)
    find_library(FMILIB_LIBRARY NAMES fmilib_shared PATHS ${FMILIB_HOME}/lib)
else()
    find_library(FMILIB_LIBRARY NAMES fmilib PATHS ${FMILIB_HOME}/lib)
endif()
mark_as_advanced(FMILIB_LIBRARY)

set(FMILIB_INCLUDE_DIRS ${FMILIB_INCLUDE_DIR})
set(FMILIB_LIBRARIES ${FMILIB_LIBRARY})

if (FMILIB_PRINT_VARS)
    message ("FMILIB find script variables:")
    message ("  FMILIB_INCLUDE_DIRS   = ${FMILIB_INCLUDE_DIRS}")
    message ("  FMILIB_LIBRARIES      = ${FMILIB_LIBRARIES}")
endif()

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(FMILIB
        REQUIRED_VARS FMILIB_LIBRARIES FMILIB_INCLUDE_DIR)
