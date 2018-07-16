//
// Created by laht on 16.07.18.
//
#include <iostream>
#include <sstream>
#include <iomanip>
#include <fmuproxy/fmi/Fmu.hpp>
#include <fmuproxy/heartbeat/Heartbeat.hpp>
#include "TestUtil.cpp"

using namespace std;
using namespace fmuproxy::fmi;
using namespace fmuproxy::heartbeat;

std::string escape_json(const std::string &s) {
    std::ostringstream o;
    for (auto c = s.cbegin(); c != s.cend(); c++) {
        if (*c == '"' || *c == '\\' || ('\x00' <= *c && *c <= '\x1f')) {
            o << "\\u"
              << std::hex << std::setw(4) << std::setfill('0') << (int)*c;
        } else {
            o << *c;
        }
    }
    return o.str();
}

//https://stackoverflow.com/questions/15571922/putting-curl-result-in-a-string-and-not-stdout
int http_get_response(void *buffer, size_t size, size_t rxed, char **msg_in)
{
    char *c;

    if (asprintf(&c, "%s%.*s", *msg_in, size * rxed, buffer) == -1) {
        free(*msg_in);
        msg_in = NULL;
        return -1;
    }

    free(*msg_in);
    *msg_in = c;

    return size * rxed;
}

int main() {

//    CURL *curl;
//    CURLcode res;
//
//    curl_global_init(CURL_GLOBAL_ALL);
//    curl = curl_easy_init();
//
//    if (curl) {
//
//        const unsigned int port = 8080;
//        const string host = "localhost";
//
//        string fmu_path = string(getenv("TEST_FMUs"))
//                          + "/FMI_2.0/CoSimulation/" + getOs() +
//                          "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";
//
//        Fmu fmu = Fmu(fmu_path);
//        string xml = fmu.get_model_description_xml();
//
//
//        string json = string("{\n"
//                             "  \"uuid\": \"1\",\n"
//                             "  \"modelDescriptionXml\": \"") + escape_json(xml) + "\",\n"
//                                                      "  \"networkInfo\": {\n"
//                                                      "    \"host\": \"localhost\",\n"
//                                                      "    \"ports\": {\n"
//                                                      "      \"thrift/tcp\": 9090\n"
//                                                      "    }\n"
//                                                      "  }\n"
//                                                      "}";
//
//        string url = "http://" + host + ":" + to_string(port) + "/fmu-proxy/registerfmu";
//        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
//        /* Now specify the POST data */
//        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, json.c_str());
//
//        char* response = new char();
//        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, http_get_response);
//        curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);
//
//        /* Perform the request, res will get the return code */
//        res = curl_easy_perform(curl);
//
//        cout << response << endl;
//
//        /* Check for errors */
//        if (res != CURLE_OK) {
//
//            fprintf(stderr, "curl_easy_perform() failed: %s\n",
//                    curl_easy_strerror(res));
//        } else {
//
//
//
//        }
//
//        curl_easy_cleanup(curl);
//
//    }
//
//    curl_global_cleanup();

    const unsigned int port = 8080;
    const string host = "localhost";

    string fmu_path = string(getenv("TEST_FMUs"))
                          + "/FMI_2.0/CoSimulation/" + getOs() +
                          "/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu";

    Fmu fmu = Fmu(fmu_path);
    string xml = fmu.get_model_description_xml();

    auto beat = Heartbeat(host, port, xml);
    beat.start();

    usleep(1 * 5000000);

    beat.stop();

    return 0;

}