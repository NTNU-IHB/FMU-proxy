
conan remote add helmesjo "https://api.bintray.com/conan/helmesjo/public-conan" --f
conan remote add inexorgame "https://api.bintray.com/conan/inexorgame/inexor-conan" --f

conan install . -s build_type=Debug --install-folder=cmake-build-debug --build=missing
conan install . -s build_type=Release --install-folder=cmake-build-release --build=missing
