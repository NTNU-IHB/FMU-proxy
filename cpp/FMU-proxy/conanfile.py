
from conans import ConanFile, CMake


class FMUProxyConan(ConanFile):

    settings = "os", "compiler", "build_type", "arch"
    generators = "cmake"
    requires = (
        "boost/1.66.0@conan/stable",
        "OpenSSL/1.0.2o@conan/stable",
        "libcurl/7.61.1@bincrafters/stable",
        "libzip/1.5.1@bincrafters/stable",
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
        "libcurl:shared=True",
        "thrift:build_compiler=False",
        "grpc:build_codegen=False"
    )

    def imports(self):
        self.copy("*.dll", dst="bin", keep_path=False)
        self.copy("*.pdb", dst="bin", keep_path=False)

    def configure(self):
        pass

    def requirements(self):
        if self.options.thrift:
            self.requires("thrift/0.12.0@helmesjo/stable")
        if self.options.grpc:
            self.requires("grpc/1.17.2@inexorgame/stable")
