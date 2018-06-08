//
// Created by laht on 07.06.18.
//

#ifndef FMU_PROXY_FMUSERVICEHANDLER_H
#define FMU_PROXY_FMUSERVICEHANDLER_H

#include <iostream>

#include "../common/thrift-gen/FmuService.h"
#include "../common/FmuWrapper.h"


using namespace std;
using namespace ::fmuproxy::thrift;


namespace fmuproxy {
    namespace server {

        class FmuServiceHandler : virtual public FmuServiceIf {

        private:
            FmuWrapper* fmu;
            map<FmuId, FmuInstance*> fmus;

        public:
            FmuServiceHandler(FmuWrapper* fmu);

            void getModelDescriptionXml(std::string &_return) override;

            void getModelDescription(ModelDescription &_return) override;

            FmuId createInstanceFromCS() override;

            FmuId createInstanceFromME(const Solver &solver) override;

            bool canGetAndSetFMUstate(const FmuId fmu_id) override;

            double getCurrentTime(const FmuId fmu_id) override;

            bool isTerminated(const FmuId fmu_id) override;

            Status::type init(const FmuId fmu_id, const double start, const double stop) override;

            void step(StepResult &_return, const FmuId fmu_id, const double step_size) override;

            Status::type terminate(const FmuId fmu_id) override;

            Status::type reset(const FmuId fmu_id) override;

            void readInteger(IntegerRead &_return, const FmuId fmu_id, const ValueReference vr) override;

            void bulkReadInteger(IntegerArrayRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

            void readReal(RealRead &_return, const FmuId fmu_id, const ValueReference vr) override;

            void bulkReadReal(RealArrayRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

            void readString(StringRead &_return, const FmuId fmu_id, const ValueReference vr) override;

            void bulkReadString(StringArrayRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

            void readBoolean(BooleanRead &_return, const FmuId fmu_id, const ValueReference vr) override;

            void bulkReadBoolean(BooleanArrayRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

            Status::type writeInteger(const FmuId fmu_id, const ValueReference vr, const int32_t value) override;

            Status::type bulkWriteInteger(const FmuId fmu_id, const ValueReferences &vr, const IntArray &value) override;

            Status::type writeReal(const FmuId fmu_id, const ValueReference vr, const double value) override;

            Status::type bulkWriteReal(const FmuId fmu_id, const ValueReferences &vr, const RealArray &value) override;

            Status::type writeString(const FmuId fmu_id, const ValueReference vr, const std::string &value) override;

            Status::type bulkWriteString(const FmuId fmu_id, const ValueReferences &vr, const StringArray &value) override;

            Status::type writeBoolean(const FmuId fmu_id, const ValueReference vr, const bool value) override;

            Status::type bulkWriteBoolean(const FmuId fmu_id, const ValueReferences &vr, const BooleanArray &value) override;

        };

    }
}

#endif //FMU_PROXY_FMUSERVICEHANDLER_H
