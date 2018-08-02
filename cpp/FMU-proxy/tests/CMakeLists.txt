cmake_minimum_required(VERSION ${CMAKE_MINIMUM_REQUIRED_VERSION})

add_executable(test1 test1.cpp)
target_link_libraries(test1 ${Boost_UNIT_TEST_FRAMEWORK_LIBRARY})


