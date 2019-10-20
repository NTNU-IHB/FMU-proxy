
from conans import ConanFile, CMake


class FMUProxyConan(ConanFile):

    settings = "os", "compiler", "build_type", "arch"
    generators = "cmake"
    requires = (
        "boost/1.66.0@conan/stable",
        "OpenSSL/1.0.2o@conan/stable",
        "libcurl/7.61.1@bincrafters/stable",
        "libzip/1.5.2@bincrafters/stable",
        "jsonformoderncpp/3.5.0@vthiery/stable",
        "bzip2/1.0.8@conan/stable"
    )
    options = {
        "thrift": [True, False],
        "grpc": [True, False]
    }
    default_options = (
        "thrift=True",
        "grpc=True",
        "libcurl:shared=True",
        "boost:shared=True"
    )

    def imports(self):
        self.copy("*.dll", dst="bin", keep_path=False)
        self.copy("*.pdb", dst="bin", keep_path=False)

    def configure(self):
        pass

    def requirements(self):
        if self.options.thrift:
            self.requires("thrift/0.12.0@bincrafters/stable")
        if self.options.grpc:
            self.requires("grpc/1.23.0@inexorgame/stable")
