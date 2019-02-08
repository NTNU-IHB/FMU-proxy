# Find Thrift
#
# Find the native Thrift headers and libraries.
#
#   THRIFT_INCLUDE_DIRS   - where to find thrift/thrift.h
#   THRIFT_LIBRARIES      - List of libraries when using Thrift.
#   THRIFT_FOUND          - True if Thrift found.
#

find_path(THRIFT_INCLUDE_DIR NAMES thrift/thrift.h)
mark_as_advanced(THRIFT_INCLUDE_DIR)

find_library(THRIFT_LIBRARY NAMES thrift thriftmd)
mark_as_advanced(THRIFT_LIBRARY)

find_library(THRIFT_LIBRARY_NB NAMES thriftnb thriftnbmd)
mark_as_advanced(THRIFT_LIBRARY_NB)

if (UNIX)
    find_library(THRIFT_LIBRARY_THREAD NAMES boost_thread)
    mark_as_advanced(THRIFT_LIBRARY_THREAD)
endif()

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(THRIFT
        REQUIRED_VARS THRIFT_LIBRARY THRIFT_LIBRARY_NB THRIFT_INCLUDE_DIR)

if (THRIFT_FOUND)

    set(THRIFT_INCLUDE_DIRS ${THRIFT_INCLUDE_DIR})

    if (NOT THRIFT_LIBRARIES)
        set(THRIFT_LIBRARIES ${THRIFT_LIBRARY} ${THRIFT_LIBRARY_NB})
    endif()

    if (NOT TARGET thrift::thrift)
        add_library(thrift::thrift UNKNOWN IMPORTED)
        set_target_properties(thrift::thrift PROPERTIES
                INTERFACE_INCLUDE_DIRECTORIES "${THRIFT_INCLUDE_DIR}")
        set_property(TARGET thrift::thrift APPEND PROPERTY
                IMPORTED_LOCATION "${THRIFT_LIBRARY}")
    endif()

    if (NOT TARGET thrift::thriftnb)
        add_library(thrift::thriftnb UNKNOWN IMPORTED)
        set_property(TARGET thrift::thriftnb APPEND PROPERTY
                IMPORTED_LOCATION "${THRIFT_LIBRARY_NB}")
    endif()

    if (UNIX AND NOT TARGET thrift::thriftthread)
        add_library(thrift::thriftthread UNKNOWN IMPORTED)
        set_property(TARGET thrift::thriftthread APPEND PROPERTY
                IMPORTED_LOCATION "${THRIFT_LIBRARY_THREAD}")
    endif()

endif()