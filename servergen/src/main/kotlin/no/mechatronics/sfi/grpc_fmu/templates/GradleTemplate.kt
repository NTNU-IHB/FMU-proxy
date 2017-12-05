package no.mechatronics.sfi.grpc_fmu.templates

object GradleTemplate {

    fun generate(mainClass: String): String {

        return """

            plugins {
                id "java"
            }

            repositories {
                mavenCentral()
                maven {
                    url "https://oss.sonatype.org/content/repositories/snapshots/"
                }
            }

            dependencies {

                compile "no.mechatronics.sfi.fmi4j:fmi-import:0.1-ALPHA-4"

                compile group: 'com.google.protobuf', name: 'protobuf-java', version: '3.5.0'
                compile group: 'com.google.protobuf', name: 'protobuf-java-util', version: '3.5.0'

                compile group: 'io.grpc', name: 'grpc-stub', version: '1.8.0'
                compile group: 'io.grpc', name: 'grpc-netty', version: '1.8.0'
                compile group: 'io.grpc', name: 'grpc-protobuf', version: '1.8.0'

                compile group: 'org.zeromq', name: 'jeromq', version: '0.4.3'

            }

            task fatJar(type: Jar) {
                manifest {
                    attributes 'Implementation-Title': 'Fmu2jar',
                    'Implementation-Version': "1.0",
                    'Main-Class': '${mainClass}'
                }
                baseName = project.name + '-all'
                from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
                with jar
            }

            """

    }

}