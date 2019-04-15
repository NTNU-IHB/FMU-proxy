# Find Thrift
#
# Find the native Thrift headers and libraries.
#
#   THRIFT_INCLUDE_DIRS   - where to find thrift/thrift.h
#   THRIFT_LIBRARIES      - List of libraries when using Thrift.
#   THRIFT_FOUND          - True if Thrift found.
#

find_path(THRIFT_INCLUDE_DIR NAMES thrift/Thrift.h)
mark_as_advanced(THRIFT_INCLUDE_DIR)

find_path(LIBEVENT_INCLUDE_DIR NAMES event2/event.h)
mark_as_advanced(LIBEVENT_INCLUDE_DIR)

find_library(THRIFT_LIBRARY NAMES thrift thriftmd thriftmdd)
mark_as_advanced(THRIFT_LIBRARY)

find_library(THRIFT_NB_LIBRARY NAMES thriftnb thriftnbmd)
mark_as_advanced(THRIFT_NB_LIBRARY)

find_library(LIBEVENT_LIBRARY NAMES event libevent)
mark_as_advanced(LIBEVENT_LIBRARY)

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(THRIFT
        REQUIRED_VARS THRIFT_LIBRARY THRIFT_NB_LIBRARY THRIFT_INCLUDE_DIR LIBEVENT_LIBRARY LIBEVENT_INCLUDE_DIR)

if (THRIFT_FOUND)

    set(THRIFT_INCLUDE_DIRS ${THRIFT_INCLUDE_DIR})

    if (NOT THRIFT_LIBRARIES)
        set(THRIFT_LIBRARIES ${THRIFT_LIBRARY} ${THRIFT_NB_LIBRARY})
    endif()

    if (NOT TARGET thrift::thrift)
        add_library(thrift::thrift UNKNOWN IMPORTED)
        set_target_properties(thrift::thrift PROPERTIES
                INTERFACE_INCLUDE_DIRECTORIES ${THRIFT_INCLUDE_DIR})
        set_property(TARGET thrift::thrift APPEND PROPERTY
                IMPORTED_LOCATION "${THRIFT_LIBRARY}")
    endif()

    if (NOT TARGET thrift::thriftnb)
        add_library(thrift::thriftnb UNKNOWN IMPORTED)
        set_property(TARGET thrift::thriftnb APPEND PROPERTY
                IMPORTED_LOCATION "${THRIFT_NB_LIBRARY}")
    endif()

    if (NOT TARGET thrift::event)
        add_library(thrift::event UNKNOWN IMPORTED)
        set_target_properties(thrift::event PROPERTIES
                INTERFACE_INCLUDE_DIRECTORIES ${LIBEVENT_INCLUDE_DIR})
        set_property(TARGET thrift::event APPEND PROPERTY
                IMPORTED_LOCATION "${LIBEVENT_LIBRARY}")
    endif()

endif()