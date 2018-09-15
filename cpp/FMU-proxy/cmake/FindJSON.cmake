# Find nlohmann-json
#
# Find the native nlohmann-json headers.
#
#   JSON_INCLUDE_DIRS   - where to find json.hpp
#   JSON_FOUND          - True if nlohmann-json found.

find_path(JSON_INCLUDE_DIR NAMES nlohmann/json.hpp)
mark_as_advanced(JSON_INCLUDE_DIR)

set(JSON_INCLUDE_DIRS ${JSON_INCLUDE_DIR})

include(FindPackageHandleStandardArgs)
FIND_PACKAGE_HANDLE_STANDARD_ARGS(JSON
        REQUIRED_VARS JSON_INCLUDE_DIR)
