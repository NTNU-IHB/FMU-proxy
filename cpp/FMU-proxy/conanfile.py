
from conans import ConanFile, CMake


class FMI4cppConan(ConanFile):

    settings = "os", "compiler", "build_type", "arch"
    generators = "cmake", "virtualrunenv"
    requires = (
        "boost/1.66.0@conan/stable",
        "OpenSSL/1.0.2o@conan/stable",
        "libcurl/7.61.1@bincrafters/stable",
        "libzip/1.5.1@bincrafters/stable",
        "spdlog/1.3.1@bincrafters/stable",
        "jsonformoderncpp/3.5.0@vthiery/stable"
    )
    options = {
        "thrift": [True, False],
        "grpc": [True, False]
    }
    default_options = (
        "thrift=True",
        "grpc=True",
        "boost:shared=True",
        "libzip:shared=True",
        "libcurl:shared=True"
    )

    def configure(self):
        pass

    def requirements(self):
        if self.options.thrift:
            self.requires("thrift/0.12.0@helmesjo/stable")
        if self.options.grpc:
            self.requires("grpc/1.17.2@inexorgame/stable")
