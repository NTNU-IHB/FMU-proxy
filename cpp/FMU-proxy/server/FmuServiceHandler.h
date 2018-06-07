//
// Created by laht on 07.06.18.
//

#ifndef FMU_PROXY_FMUSERVICEHANDLER_H
#define FMU_PROXY_FMUSERVICEHANDLER_H

#endif //FMU_PROXY_FMUSERVICEHANDLER_H

#include <iostream>

#include "../common/thrift-gen/FmuService.h"
#include "FmuWrapper.h"


using namespace std;
using namespace ::fmuproxy::thrift;

int id_gen = 0;

namespace fmuproxy {
    namespace server {

        class FmuServiceHandler : virtual public FmuServiceIf {

        private:
            FmuWrapper* fmu;
            map<FmuId, FmuInstance*> fmus;

        public:
            FmuServiceHandler(const char* fmu_path)
                    : fmu(new FmuWrapper(fmu_path)) {}

            void getModelDescriptionXml(std::string& _return) {
                _return = "XML placeholder";
            }

            void getModelDescription( ::ModelDescription& _return) {
                _return = *fmu-> getModelDescription();
            }

            FmuId createInstanceFromCS() {
                FmuInstance* instance = fmu->newInstance();
                FmuId my_id = id_gen++;
                fmus[my_id] = instance;
                cout << "create instance with id=" << my_id << endl;
                return my_id;
            }

            FmuId createInstanceFromME(const  ::Solver& solver) {
                // Your implementation goes here
                printf("createInstanceFromME\n");
            }

            bool canGetAndSetFMUstate(const FmuId fmu_id) {
                return false;
            }

            double getCurrentTime(const FmuId fmu_id) {
                FmuInstance* instance = fmus[fmu_id];
                return instance->getCurrentTime();
            }

            bool isTerminated(const FmuId fmu_id) {
                FmuInstance* instance = fmus[fmu_id];
                return instance->isTerminated();
            }

            ::Status::type init(const FmuId fmu_id, const double start, const double stop) {
                FmuInstance* instance = fmus[fmu_id];
                instance->init(start, stop);
                return ::Status::OK_STATUS;
            }

            void step( ::StepResult& _return, const FmuId fmu_id, const double step_size) {
                FmuInstance* instance = fmus[fmu_id];
                instance->step(step_size, _return);
            }

            ::Status::type terminate(const FmuId fmu_id) {
                FmuInstance *instance = fmus[fmu_id];
                Status::type status = instance->terminate();
                delete instance;
                return status;
            }

            ::Status::type reset(const FmuId fmu_id) {
                FmuInstance* instance = fmus[fmu_id];
                return instance->reset();
            }

            void readInteger( ::IntegerRead& _return, const FmuId fmu_id, const ValueReference vr) {
                FmuInstance* instance = fmus[fmu_id];
                instance->getInteger(vr, _return);
            }

            void bulkReadInteger( ::IntegerArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
                FmuInstance* instance = fmus[fmu_id];
            }

            void readReal( ::RealRead& _return, const FmuId fmu_id, const ValueReference vr) {
                FmuInstance* instance = fmus[fmu_id];
                instance->getReal(vr, _return);
            }

            void bulkReadReal( ::RealArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
                FmuInstance* instance = fmus[fmu_id];
            }

            void readString( ::StringRead& _return, const FmuId fmu_id, const ValueReference vr) {
                FmuInstance* instance = fmus[fmu_id];
                instance->getString(vr, _return);
            }

            void bulkReadString( ::StringArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
                FmuInstance* instance = fmus[fmu_id];
            }

            void readBoolean( ::BooleanRead& _return, const FmuId fmu_id, const ValueReference vr) {
                FmuInstance* instance = fmus[fmu_id];
                instance->getBoolean(vr, _return);
            }

            void bulkReadBoolean( ::BooleanArrayRead& _return, const FmuId fmu_id, const ValueReferences& vr) {
                FmuInstance* instance = fmus[fmu_id];
            }

            ::Status::type writeInteger(const FmuId fmu_id, const ValueReference vr, const int32_t value) {
                // Your implementation goes here
                printf("writeInteger\n");
            }

            ::Status::type bulkWriteInteger(const FmuId fmu_id, const ValueReferences& vr, const IntArray& value) {
                // Your implementation goes here
                printf("bulkWriteInteger\n");
            }

            ::Status::type writeReal(const FmuId fmu_id, const ValueReference vr, const double value) {
                // Your implementation goes here
                printf("writeReal\n");
            }

            ::Status::type bulkWriteReal(const FmuId fmu_id, const ValueReferences& vr, const RealArray& value) {
                // Your implementation goes here
                printf("bulkWriteReal\n");
            }

            ::Status::type writeString(const FmuId fmu_id, const ValueReference vr, const std::string& value) {
                // Your implementation goes here
                printf("writeString\n");
            }

            ::Status::type bulkWriteString(const FmuId fmu_id, const ValueReferences& vr, const StringArray& value) {
                // Your implementation goes here
                printf("bulkWriteString\n");
            }

            ::Status::type writeBoolean(const FmuId fmu_id, const ValueReference vr, const bool value) {
                // Your implementation goes here
                printf("writeBoolean\n");
            }

            ::Status::type bulkWriteBoolean(const FmuId fmu_id, const ValueReferences& vr, const BooleanArray& value) {
                // Your implementation goes here
                printf("bulkWriteBoolean\n");
            }

            ~FmuServiceHandler() {
                delete fmu;
            }

        };

    }
}
