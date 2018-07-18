# Find Curl
#
# Find the native Curl headers and libraries.
#
#   CURL_INCLUDE_DIRS   - where to find curl/curl.h
#   CURL_LIBRARIES      - List of libraries when using Curl.
#   CURL_FOUND          - True if Curl found.

cmake_minimum_required (VERSION 3.10)

find_path(CURL_INCLUDE_DIR NAMES
        curl/curl.h
        PATHS
        ${CURL_HOME}/include)
mark_as_advanced(CURL_INCLUDE_DIR)

find_library(CURL_LIBRARY NAMES curl curllib libcurl_imp PATHS ${CURL_HOME}/lib)
mark_as_advanced(CURL_LIBRARY)

if(CURL_INCLUDE_DIR)
    foreach(_curl_version_header curlver.h curl.h)
        if(EXISTS "${CURL_INCLUDE_DIR}/curl/${_curl_version_header}")
            file(STRINGS "${CURL_INCLUDE_DIR}/curl/${_curl_version_header}" curl_version_str REGEX "^#define[\t ]+LIBCURL_VERSION[\t ]+\".*\"")

            string(REGEX REPLACE "^#define[\t ]+LIBCURL_VERSION[\t ]+\"([^\"]*)\".*" "\\1" CURL_VERSION_STRING "${curl_version_str}")
            unset(curl_version_str)
            break()
        endif()
    endforeach()
endif()

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(CURL
        REQUIRED_VARS CURL_LIBRARY CURL_INCLUDE_DIR)

if(CURL_FOUND)
    set(CURL_LIBRARIES ${CURL_LIBRARY})
    set(CURL_INCLUDE_DIRS ${CURL_INCLUDE_DIR})
endif()

if (CURL_PRINT_VARS)
    message ("CURL find script variables:")
    message ("  CURL_INCLUDE_DIRS   = ${CURL_INCLUDE_DIRS}")
    message ("  CURL_LIBRARIES      = ${CURL_LIBRARIES}")
endif ()
