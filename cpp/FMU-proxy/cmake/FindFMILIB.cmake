# - CMake script for locating FMI Library
#
# This script is run by the command find_package(FMILIB). The location of the
# package may be explicitly specified using an environment variable named
# FMILIB_DIR or a CMake variable of the same name.  If both are specified, the
# latter takes precedence.  The variable should point to the package
# installation prefix, i.e. the directory that contains the "bin", "lib" and
# "include" subdirectories.
#
# The script searches for both static and shared/dynamic libraries, and creates
# IMPORTED targets named "fmilib" and "fmilib_shared", respectively.  These
# targets will have several of their IMPORTED_* and INTERFACE_* properties set,
# making explicit use of commands like include_directories() superfluous in most
# cases.
#
# If the variable FMILIB_USE_SHARED_LIB is set to TRUE, FMILIB_LIBRARIES will
# contain the name of the IMPORTED target "fmilib_shared". Otherwise, it will
# contain "fmilib".
#
# After the script has completed, the variable FMILIB_FOUND will contain whether
# the package was found or not.  If it was, then the following variables will
# also be set:
#
#    FMILIB_INCLUDE_DIRS    - The directory that contains the header files.
#    FMILIB_LIBRARIES       - The name of an IMPORTED target.
#
#    FMILIB_DLL             - Path to dynamic library (Windows only).
#    FMILIB_LIBRARY         - Path to static library.
#    FMILIB_SHARED_LIBRARY  - Path to shared/import library.
#
cmake_minimum_required (VERSION 2.8.11)

SET(FMILIB_HOME $ENV{FMILIB_HOME})
if(WIN32)
    SET(FMILIB_DIR ${FMILIB_HOME}/include)
    SET(FMILIB_DLL ${FMILIB_HOME}/lib)
    SET(FMILIB_LIBRARY ${FMILIB_HOME}/lib)
    SET(FMILIB_SHARED_LIBRARY ${FMILIB_HOME}/lib)
endif()

# Find static library, and use its path prefix to provide a HINTS option to the
# other find_*() commands.
if (UNIX)
    set (_FMILIB_oldsuffixes ${CMAKE_FIND_LIBRARY_SUFFIXES})
    set (CMAKE_FIND_LIBRARY_SUFFIXES ".a")
endif ()
find_library (FMILIB_LIBRARY
        NAMES "fmilib2" "fmilib"
        PATHS ${FMILIB_DIR} $ENV{FMILIB_DIR}
        PATH_SUFFIXES "lib")
mark_as_advanced (FMILIB_LIBRARY)
unset (_FMILIB_hints)
if (FMILIB_LIBRARY)
    get_filename_component (_FMILIB_prefix "${FMILIB_LIBRARY}" PATH)
    get_filename_component (_FMILIB_prefix "${_FMILIB_prefix}" PATH)
    set (_FMILIB_hints "HINTS" "${_FMILIB_prefix}")
    unset (_FMILIB_prefix)
endif ()

# Find shared/import library and append its path prefix to the HINTS option.
if (UNIX)
    set (CMAKE_FIND_LIBRARY_SUFFIXES ".so")
    set (_FMILIB_shlibs "fmilib_shared" "fmilib2" "fmilib")
else ()
    set (_FMILIB_shlibs "fmilib_shared")
endif ()
find_library (FMILIB_SHARED_LIBRARY
        NAMES ${_FMILIB_shlibs}
        ${_FMILIB_hints}
        PATHS ${FMILIB_DIR} $ENV{FMILIB_DIR}
        PATH_SUFFIXES "lib")
mark_as_advanced (FMILIB_SHARED_LIBRARY)
if (FMILIB_SHARED_LIBRARY)
    get_filename_component (_FMILIB_shared_prefix "${FMILIB_SHARED_LIBRARY}" PATH)
    get_filename_component (_FMILIB_shared_prefix "${_FMILIB_shared_prefix}" PATH)
    if (NOT _FMILIB_hints)
        set (_FMILIB_hints "HINTS")
    endif ()
    list (APPEND _FMILIB_hints "${_FMILIB_shared_prefix}")
    unset (_FMILIB_shared_prefix)
endif ()

# Reset CMAKE_FIND_LIBRARY_SUFFIXES
if (UNIX)
    set (CMAKE_FIND_LIBRARY_SUFFIXES ${_FMILIB_oldsuffixes})
    unset (_FMILIB_oldsuffixes)
endif ()

# Find header files and, on Windows, the dynamic library
find_path (FMILIB_INCLUDE_DIRS "fmilib.h"
        ${_FMILIB_hints}
        PATHS ${FMILIB_DIR} $ENV{FMILIB_DIR}
        PATH_SUFFIXES "include")
mark_as_advanced (FMILIB_INCLUDE_DIRS)

if (WIN32)
    find_file (FMILIB_DLL "fmilib_shared.dll"
            ${_FMILIB_hints}
            PATHS ${FMILIB_DIR} $ENV{FMILIB_DIR}
            PATH_SUFFIXES "bin" "lib"
            NO_CMAKE_PATH NO_CMAKE_ENVIRONMENT_PATH NO_CMAKE_SYSTEM_PATH)
    mark_as_advanced (FMILIB_DLL)
endif ()
unset (_FMILIB_hints)

# Create the IMPORTED targets.
if (FMILIB_LIBRARY)
    add_library ("fmilib" STATIC IMPORTED)
    set_target_properties ("fmilib" PROPERTIES
            IMPORTED_LINK_INTERFACE_LANGUAGES "C"
            IMPORTED_LINK_INTERFACE_LIBRARIES "${CMAKE_DL_LIBS}"
            IMPORTED_LOCATION "${FMILIB_LIBRARY}"
            INTERFACE_COMPILE_DEFINITIONS "FMILIB_STATIC_LIB_ONLY"
            INTERFACE_INCLUDE_DIRECTORIES "${FMILIB_INCLUDE_DIRS}")
endif ()

if (FMILIB_SHARED_LIBRARY)
    add_library ("fmilib_shared" SHARED IMPORTED)
    set_target_properties ("fmilib_shared" PROPERTIES
            IMPORTED_LINK_INTERFACE_LANGUAGES "C"
            INTERFACE_INCLUDE_DIRECTORIES "${FMILIB_INCLUDE_DIRS}")
    if (WIN32)
        set_target_properties ("fmilib_shared" PROPERTIES
                IMPORTED_IMPLIB "${FMILIB_SHARED_LIBRARY}")
        if (FMILIB_DLL)
            set_target_properties ("fmilib_shared" PROPERTIES
                    IMPORTED_LOCATION "${FMILIB_DLL}")
        endif ()
    else () # not WIN32
        set_target_properties ("fmilib_shared" PROPERTIES
                IMPORTED_LOCATION "${FMILIB_SHARED_LIBRARY}")
    endif ()
endif ()

# Set the FMILIB_LIBRARIES variable.
unset (FMILIB_LIBRARIES)
if (FMILIB_USE_SHARED_LIB)
    if (FMILIB_SHARED_LIBRARY)
        set (FMILIB_LIBRARIES "fmilib_shared")
    endif ()
else ()
    if (FMILIB_LIBRARY)
        set (FMILIB_LIBRARIES "fmilib")
    endif ()
endif ()

# Debug print-out.
if (FMILIB_PRINT_VARS)
    message ("FMILIB find script variables:")
    message ("  FMILIB_INCLUDE_DIRS   = ${FMILIB_INCLUDE_DIRS}")
    message ("  FMILIB_LIBRARIES      = ${FMILIB_LIBRARIES}")
    message ("  FMILIB_DLL            = ${FMILIB_DLL}")
    message ("  FMILIB_LIBRARY        = ${FMILIB_LIBRARY}")
    message ("  FMILIB_SHARED_LIBRARY = ${FMILIB_SHARED_LIBRARY}")
endif ()

# Standard find_package stuff.
include (FindPackageHandleStandardArgs)
find_package_handle_standard_args (FMILIB DEFAULT_MSG FMILIB_LIBRARIES FMILIB_INCLUDE_DIRS)