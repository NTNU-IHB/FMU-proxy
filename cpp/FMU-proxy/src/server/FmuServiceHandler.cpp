//
// Created by laht on 08.06.18.
//

#include "../common/FmuWrapper.hpp"
#include "FmuServiceHandler.hpp"

int id_gen = 0;

using namespace fmuproxy;
using namespace fmuproxy::thrift;
using namespace fmuproxy::server;

::FmuServiceHandler::FmuServiceHandler(FmuWrapper &fmu): fmu(fmu) {}

void FmuServiceHandler::getModelDescriptionXml(std::string &_return) {
    _return = "XML placeholder";
}

void FmuServiceHandler::getModelDescription(ModelDescription &_return) {
    _return = fmu.getModelDescription();
}

FmuId FmuServiceHandler::createInstanceFromCS() {
    FmuId my_id = id_gen++;
    fmus[my_id] = fmu.newInstance();
    cout << "create instance with id=" << my_id << endl;
    return my_id;
}

FmuId FmuServiceHandler::createInstanceFromME(const Solver &solver) {
    return 0;
}

bool FmuServiceHandler::canGetAndSetFMUstate(const FmuId fmu_id) {
    return false;
}

double FmuServiceHandler::getCurrentTime(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    return instance->getCurrentTime();
}

bool FmuServiceHandler::isTerminated(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    return instance->isTerminated();
}

Status::type FmuServiceHandler::init(const FmuId fmu_id, const double start, const double stop) {
    auto& instance = fmus[fmu_id];
    instance->init(start, stop);
    return ::Status::OK_STATUS;
}

void FmuServiceHandler::step(StepResult &_return, const FmuId fmu_id, const double step_size) {
    auto& instance = fmus[fmu_id];
    instance->step(step_size, _return);
}

Status::type FmuServiceHandler::terminate(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    Status::type status = instance->terminate();
    fmus.erase(fmu_id);
    return status;
}

Status::type FmuServiceHandler::reset(const FmuId fmu_id) {
    auto& instance = fmus[fmu_id];
    return instance->reset();
}

void FmuServiceHandler::readInteger(IntegerRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    instance->getInteger(vr, _return);
}

void FmuServiceHandler::bulkReadInteger(BulkIntegerRead &_return, const FmuId fmu_id, const ValueReferences &vr) {

}

void FmuServiceHandler::readReal(RealRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    instance->getReal(vr, _return);
}

void FmuServiceHandler::bulkReadReal(BulkRealRead &_return, const FmuId fmu_id, const ValueReferences &vr) {

}

void FmuServiceHandler::readString(StringRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    instance->getString(vr, _return);
}

void FmuServiceHandler::bulkReadString(BulkStringRead &_return, const FmuId fmu_id, const ValueReferences &vr) {

}

void FmuServiceHandler::readBoolean(BooleanRead &_return, const FmuId fmu_id, const ValueReference vr) {
    auto& instance = fmus[fmu_id];
    instance->getBoolean(vr, _return);
}

void FmuServiceHandler::bulkReadBoolean(BulkBooleanRead &_return, const FmuId fmu_id, const ValueReferences &vr) {

}

Status::type FmuServiceHandler::writeInteger(const FmuId fmu_id, const ValueReference vr, const int32_t value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteInteger(const FmuId fmu_id, const ValueReferences &vr, const IntArray &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::writeReal(const FmuId fmu_id, const ValueReference vr, const double value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteReal(const FmuId fmu_id, const ValueReferences &vr, const RealArray &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::writeString(const FmuId fmu_id, const ValueReference vr, const std::string &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteString(const FmuId fmu_id, const ValueReferences &vr, const StringArray &value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::writeBoolean(const FmuId fmu_id, const ValueReference vr, const bool value) {
    return Status::type::DISCARD_STATUS;
}

Status::type FmuServiceHandler::bulkWriteBoolean(const FmuId fmu_id, const ValueReferences &vr, const BooleanArray &value) {
    return Status::type::DISCARD_STATUS;
}
