/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef definitions_TYPES_H
#define definitions_TYPES_H

#include <iosfwd>

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/TBase.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/stdcxx.h>


namespace fmuproxy { namespace thrift {

struct Status {
  enum type {
    OK_STATUS = 0,
    WARNING_STATUS = 1,
    DISCARD_STATUS = 2,
    ERROR_STATUS = 3,
    FATAL_STATUS = 4,
    PENDING_STATUS = 5
  };
};

extern const std::map<int, const char*> _Status_VALUES_TO_NAMES;

std::ostream& operator<<(std::ostream& out, const Status::type& val);

struct Causality {
  enum type {
    INPUT_CAUSALITY = 0,
    OUTPUT_CAUSALITY = 1,
    PARAMETER_CAUSALITY = 2,
    CALCULATED_PARAMETER_CAUSALITY = 3,
    LOCAL_CAUSALITY = 4,
    INDEPENDENT_CAUSALITY = 5,
    UNKNOWN_CAUSALITY = 6
  };
};

extern const std::map<int, const char*> _Causality_VALUES_TO_NAMES;

std::ostream& operator<<(std::ostream& out, const Causality::type& val);

struct Variability {
  enum type {
    CONSTANT_VARIABILITY = 0,
    FIXED_VARIABILITY = 1,
    CONTINUOUS_VARIABILITY = 2,
    DISCRETE_VARIABILITY = 3,
    TUNABLE_VARIABILITY = 4,
    UNKNOWN_VARIABILITY = 6
  };
};

extern const std::map<int, const char*> _Variability_VALUES_TO_NAMES;

std::ostream& operator<<(std::ostream& out, const Variability::type& val);

struct Initial {
  enum type {
    EXACT_INITIAL = 0,
    APPROX_INITIAL = 1,
    CALCULATED_INITIAL = 2,
    UNKNOWN_INITIAL = 3
  };
};

extern const std::map<int, const char*> _Initial_VALUES_TO_NAMES;

std::ostream& operator<<(std::ostream& out, const Initial::type& val);

typedef std::vector<class ScalarVariable>  ModelVariables;

class IntegerAttribute;

class RealAttribute;

class StringAttribute;

class BooleanAttribute;

class EnumerationAttribute;

class ScalarVariableAttribute;

class ScalarVariable;

class Unknown;

class ModelStructure;

class DefaultExperiment;

class StepResult;

class IntegerRead;

class RealRead;

class StringRead;

class BooleanRead;

class Solver;

class ModelDescription;

class CoSimulationAttributes;

typedef struct _IntegerAttribute__isset {
  _IntegerAttribute__isset() : min(false), max(false), start(false), quantity(false) {}
  bool min :1;
  bool max :1;
  bool start :1;
  bool quantity :1;
} _IntegerAttribute__isset;

class IntegerAttribute : public virtual ::apache::thrift::TBase {
 public:

  IntegerAttribute(const IntegerAttribute&);
  IntegerAttribute& operator=(const IntegerAttribute&);
  IntegerAttribute() : min(0), max(0), start(0), quantity() {
  }

  virtual ~IntegerAttribute() throw();
  int32_t min;
  int32_t max;
  int32_t start;
  std::string quantity;

  _IntegerAttribute__isset __isset;

  void __set_min(const int32_t val);

  void __set_max(const int32_t val);

  void __set_start(const int32_t val);

  void __set_quantity(const std::string& val);

  bool operator == (const IntegerAttribute & rhs) const
  {
    if (!(min == rhs.min))
      return false;
    if (!(max == rhs.max))
      return false;
    if (!(start == rhs.start))
      return false;
    if (!(quantity == rhs.quantity))
      return false;
    return true;
  }
  bool operator != (const IntegerAttribute &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const IntegerAttribute & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(IntegerAttribute &a, IntegerAttribute &b);

std::ostream& operator<<(std::ostream& out, const IntegerAttribute& obj);

typedef struct _RealAttribute__isset {
  _RealAttribute__isset() : min(false), max(false), start(false), quantity(false) {}
  bool min :1;
  bool max :1;
  bool start :1;
  bool quantity :1;
} _RealAttribute__isset;

class RealAttribute : public virtual ::apache::thrift::TBase {
 public:

  RealAttribute(const RealAttribute&);
  RealAttribute& operator=(const RealAttribute&);
  RealAttribute() : min(0), max(0), start(0), quantity() {
  }

  virtual ~RealAttribute() throw();
  double min;
  double max;
  double start;
  std::string quantity;

  _RealAttribute__isset __isset;

  void __set_min(const double val);

  void __set_max(const double val);

  void __set_start(const double val);

  void __set_quantity(const std::string& val);

  bool operator == (const RealAttribute & rhs) const
  {
    if (!(min == rhs.min))
      return false;
    if (!(max == rhs.max))
      return false;
    if (!(start == rhs.start))
      return false;
    if (!(quantity == rhs.quantity))
      return false;
    return true;
  }
  bool operator != (const RealAttribute &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const RealAttribute & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(RealAttribute &a, RealAttribute &b);

std::ostream& operator<<(std::ostream& out, const RealAttribute& obj);

typedef struct _StringAttribute__isset {
  _StringAttribute__isset() : start(false) {}
  bool start :1;
} _StringAttribute__isset;

class StringAttribute : public virtual ::apache::thrift::TBase {
 public:

  StringAttribute(const StringAttribute&);
  StringAttribute& operator=(const StringAttribute&);
  StringAttribute() : start() {
  }

  virtual ~StringAttribute() throw();
  std::string start;

  _StringAttribute__isset __isset;

  void __set_start(const std::string& val);

  bool operator == (const StringAttribute & rhs) const
  {
    if (!(start == rhs.start))
      return false;
    return true;
  }
  bool operator != (const StringAttribute &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const StringAttribute & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(StringAttribute &a, StringAttribute &b);

std::ostream& operator<<(std::ostream& out, const StringAttribute& obj);

typedef struct _BooleanAttribute__isset {
  _BooleanAttribute__isset() : start(false) {}
  bool start :1;
} _BooleanAttribute__isset;

class BooleanAttribute : public virtual ::apache::thrift::TBase {
 public:

  BooleanAttribute(const BooleanAttribute&);
  BooleanAttribute& operator=(const BooleanAttribute&);
  BooleanAttribute() : start(0) {
  }

  virtual ~BooleanAttribute() throw();
  bool start;

  _BooleanAttribute__isset __isset;

  void __set_start(const bool val);

  bool operator == (const BooleanAttribute & rhs) const
  {
    if (!(start == rhs.start))
      return false;
    return true;
  }
  bool operator != (const BooleanAttribute &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const BooleanAttribute & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(BooleanAttribute &a, BooleanAttribute &b);

std::ostream& operator<<(std::ostream& out, const BooleanAttribute& obj);

typedef struct _EnumerationAttribute__isset {
  _EnumerationAttribute__isset() : min(false), max(false), start(false), quantity(false) {}
  bool min :1;
  bool max :1;
  bool start :1;
  bool quantity :1;
} _EnumerationAttribute__isset;

class EnumerationAttribute : public virtual ::apache::thrift::TBase {
 public:

  EnumerationAttribute(const EnumerationAttribute&);
  EnumerationAttribute& operator=(const EnumerationAttribute&);
  EnumerationAttribute() : min(0), max(0), start(0), quantity() {
  }

  virtual ~EnumerationAttribute() throw();
  int32_t min;
  int32_t max;
  int32_t start;
  std::string quantity;

  _EnumerationAttribute__isset __isset;

  void __set_min(const int32_t val);

  void __set_max(const int32_t val);

  void __set_start(const int32_t val);

  void __set_quantity(const std::string& val);

  bool operator == (const EnumerationAttribute & rhs) const
  {
    if (!(min == rhs.min))
      return false;
    if (!(max == rhs.max))
      return false;
    if (!(start == rhs.start))
      return false;
    if (!(quantity == rhs.quantity))
      return false;
    return true;
  }
  bool operator != (const EnumerationAttribute &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const EnumerationAttribute & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(EnumerationAttribute &a, EnumerationAttribute &b);

std::ostream& operator<<(std::ostream& out, const EnumerationAttribute& obj);

typedef struct _ScalarVariableAttribute__isset {
  _ScalarVariableAttribute__isset() : integerAttribute(false), realAttribute(false), stringAttribute(false), booleanAttribute(false), enumerationAttribute(false) {}
  bool integerAttribute :1;
  bool realAttribute :1;
  bool stringAttribute :1;
  bool booleanAttribute :1;
  bool enumerationAttribute :1;
} _ScalarVariableAttribute__isset;

class ScalarVariableAttribute : public virtual ::apache::thrift::TBase {
 public:

  ScalarVariableAttribute(const ScalarVariableAttribute&);
  ScalarVariableAttribute& operator=(const ScalarVariableAttribute&);
  ScalarVariableAttribute() {
  }

  virtual ~ScalarVariableAttribute() throw();
  IntegerAttribute integerAttribute;
  RealAttribute realAttribute;
  StringAttribute stringAttribute;
  BooleanAttribute booleanAttribute;
  EnumerationAttribute enumerationAttribute;

  _ScalarVariableAttribute__isset __isset;

  void __set_integerAttribute(const IntegerAttribute& val);

  void __set_realAttribute(const RealAttribute& val);

  void __set_stringAttribute(const StringAttribute& val);

  void __set_booleanAttribute(const BooleanAttribute& val);

  void __set_enumerationAttribute(const EnumerationAttribute& val);

  bool operator == (const ScalarVariableAttribute & rhs) const
  {
    if (__isset.integerAttribute != rhs.__isset.integerAttribute)
      return false;
    else if (__isset.integerAttribute && !(integerAttribute == rhs.integerAttribute))
      return false;
    if (__isset.realAttribute != rhs.__isset.realAttribute)
      return false;
    else if (__isset.realAttribute && !(realAttribute == rhs.realAttribute))
      return false;
    if (__isset.stringAttribute != rhs.__isset.stringAttribute)
      return false;
    else if (__isset.stringAttribute && !(stringAttribute == rhs.stringAttribute))
      return false;
    if (__isset.booleanAttribute != rhs.__isset.booleanAttribute)
      return false;
    else if (__isset.booleanAttribute && !(booleanAttribute == rhs.booleanAttribute))
      return false;
    if (__isset.enumerationAttribute != rhs.__isset.enumerationAttribute)
      return false;
    else if (__isset.enumerationAttribute && !(enumerationAttribute == rhs.enumerationAttribute))
      return false;
    return true;
  }
  bool operator != (const ScalarVariableAttribute &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const ScalarVariableAttribute & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(ScalarVariableAttribute &a, ScalarVariableAttribute &b);

std::ostream& operator<<(std::ostream& out, const ScalarVariableAttribute& obj);

typedef struct _ScalarVariable__isset {
  _ScalarVariable__isset() : valueReference(false), name(false), description(false), initial(false), causality(false), variability(false), attribute(false) {}
  bool valueReference :1;
  bool name :1;
  bool description :1;
  bool initial :1;
  bool causality :1;
  bool variability :1;
  bool attribute :1;
} _ScalarVariable__isset;

class ScalarVariable : public virtual ::apache::thrift::TBase {
 public:

  ScalarVariable(const ScalarVariable&);
  ScalarVariable& operator=(const ScalarVariable&);
  ScalarVariable() : valueReference(0), name(), description(), initial((Initial::type)0), causality((Causality::type)0), variability((Variability::type)0) {
  }

  virtual ~ScalarVariable() throw();
  int64_t valueReference;
  std::string name;
  std::string description;
  Initial::type initial;
  Causality::type causality;
  Variability::type variability;
  ScalarVariableAttribute attribute;

  _ScalarVariable__isset __isset;

  void __set_valueReference(const int64_t val);

  void __set_name(const std::string& val);

  void __set_description(const std::string& val);

  void __set_initial(const Initial::type val);

  void __set_causality(const Causality::type val);

  void __set_variability(const Variability::type val);

  void __set_attribute(const ScalarVariableAttribute& val);

  bool operator == (const ScalarVariable & rhs) const
  {
    if (!(valueReference == rhs.valueReference))
      return false;
    if (!(name == rhs.name))
      return false;
    if (__isset.description != rhs.__isset.description)
      return false;
    else if (__isset.description && !(description == rhs.description))
      return false;
    if (__isset.initial != rhs.__isset.initial)
      return false;
    else if (__isset.initial && !(initial == rhs.initial))
      return false;
    if (__isset.causality != rhs.__isset.causality)
      return false;
    else if (__isset.causality && !(causality == rhs.causality))
      return false;
    if (__isset.variability != rhs.__isset.variability)
      return false;
    else if (__isset.variability && !(variability == rhs.variability))
      return false;
    if (!(attribute == rhs.attribute))
      return false;
    return true;
  }
  bool operator != (const ScalarVariable &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const ScalarVariable & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(ScalarVariable &a, ScalarVariable &b);

std::ostream& operator<<(std::ostream& out, const ScalarVariable& obj);

typedef struct _Unknown__isset {
  _Unknown__isset() : index(false), dependencies(false), dependenciesKind(false) {}
  bool index :1;
  bool dependencies :1;
  bool dependenciesKind :1;
} _Unknown__isset;

class Unknown : public virtual ::apache::thrift::TBase {
 public:

  Unknown(const Unknown&);
  Unknown& operator=(const Unknown&);
  Unknown() : index(0), dependenciesKind() {
  }

  virtual ~Unknown() throw();
  int32_t index;
  std::vector<int32_t>  dependencies;
  std::string dependenciesKind;

  _Unknown__isset __isset;

  void __set_index(const int32_t val);

  void __set_dependencies(const std::vector<int32_t> & val);

  void __set_dependenciesKind(const std::string& val);

  bool operator == (const Unknown & rhs) const
  {
    if (!(index == rhs.index))
      return false;
    if (!(dependencies == rhs.dependencies))
      return false;
    if (!(dependenciesKind == rhs.dependenciesKind))
      return false;
    return true;
  }
  bool operator != (const Unknown &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Unknown & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(Unknown &a, Unknown &b);

std::ostream& operator<<(std::ostream& out, const Unknown& obj);

typedef struct _ModelStructure__isset {
  _ModelStructure__isset() : outputs(false), derivatives(false), initialUnknowns(false) {}
  bool outputs :1;
  bool derivatives :1;
  bool initialUnknowns :1;
} _ModelStructure__isset;

class ModelStructure : public virtual ::apache::thrift::TBase {
 public:

  ModelStructure(const ModelStructure&);
  ModelStructure& operator=(const ModelStructure&);
  ModelStructure() {
  }

  virtual ~ModelStructure() throw();
  std::vector<Unknown>  outputs;
  std::vector<Unknown>  derivatives;
  std::vector<Unknown>  initialUnknowns;

  _ModelStructure__isset __isset;

  void __set_outputs(const std::vector<Unknown> & val);

  void __set_derivatives(const std::vector<Unknown> & val);

  void __set_initialUnknowns(const std::vector<Unknown> & val);

  bool operator == (const ModelStructure & rhs) const
  {
    if (!(outputs == rhs.outputs))
      return false;
    if (!(derivatives == rhs.derivatives))
      return false;
    if (!(initialUnknowns == rhs.initialUnknowns))
      return false;
    return true;
  }
  bool operator != (const ModelStructure &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const ModelStructure & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(ModelStructure &a, ModelStructure &b);

std::ostream& operator<<(std::ostream& out, const ModelStructure& obj);

typedef struct _DefaultExperiment__isset {
  _DefaultExperiment__isset() : startTime(false), stopTime(false), tolerance(false), stepSize(false) {}
  bool startTime :1;
  bool stopTime :1;
  bool tolerance :1;
  bool stepSize :1;
} _DefaultExperiment__isset;

class DefaultExperiment : public virtual ::apache::thrift::TBase {
 public:

  DefaultExperiment(const DefaultExperiment&);
  DefaultExperiment& operator=(const DefaultExperiment&);
  DefaultExperiment() : startTime(0), stopTime(0), tolerance(0), stepSize(0) {
  }

  virtual ~DefaultExperiment() throw();
  double startTime;
  double stopTime;
  double tolerance;
  double stepSize;

  _DefaultExperiment__isset __isset;

  void __set_startTime(const double val);

  void __set_stopTime(const double val);

  void __set_tolerance(const double val);

  void __set_stepSize(const double val);

  bool operator == (const DefaultExperiment & rhs) const
  {
    if (!(startTime == rhs.startTime))
      return false;
    if (!(stopTime == rhs.stopTime))
      return false;
    if (!(tolerance == rhs.tolerance))
      return false;
    if (!(stepSize == rhs.stepSize))
      return false;
    return true;
  }
  bool operator != (const DefaultExperiment &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const DefaultExperiment & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(DefaultExperiment &a, DefaultExperiment &b);

std::ostream& operator<<(std::ostream& out, const DefaultExperiment& obj);

typedef struct _StepResult__isset {
  _StepResult__isset() : status(false), simulationTime(false) {}
  bool status :1;
  bool simulationTime :1;
} _StepResult__isset;

class StepResult : public virtual ::apache::thrift::TBase {
 public:

  StepResult(const StepResult&);
  StepResult& operator=(const StepResult&);
  StepResult() : status((Status::type)0), simulationTime(0) {
  }

  virtual ~StepResult() throw();
  Status::type status;
  double simulationTime;

  _StepResult__isset __isset;

  void __set_status(const Status::type val);

  void __set_simulationTime(const double val);

  bool operator == (const StepResult & rhs) const
  {
    if (!(status == rhs.status))
      return false;
    if (!(simulationTime == rhs.simulationTime))
      return false;
    return true;
  }
  bool operator != (const StepResult &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const StepResult & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(StepResult &a, StepResult &b);

std::ostream& operator<<(std::ostream& out, const StepResult& obj);

typedef struct _IntegerRead__isset {
  _IntegerRead__isset() : value(false), status(false) {}
  bool value :1;
  bool status :1;
} _IntegerRead__isset;

class IntegerRead : public virtual ::apache::thrift::TBase {
 public:

  IntegerRead(const IntegerRead&);
  IntegerRead& operator=(const IntegerRead&);
  IntegerRead() : status((Status::type)0) {
  }

  virtual ~IntegerRead() throw();
  std::vector<int32_t>  value;
  Status::type status;

  _IntegerRead__isset __isset;

  void __set_value(const std::vector<int32_t> & val);

  void __set_status(const Status::type val);

  bool operator == (const IntegerRead & rhs) const
  {
    if (!(value == rhs.value))
      return false;
    if (!(status == rhs.status))
      return false;
    return true;
  }
  bool operator != (const IntegerRead &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const IntegerRead & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(IntegerRead &a, IntegerRead &b);

std::ostream& operator<<(std::ostream& out, const IntegerRead& obj);

typedef struct _RealRead__isset {
  _RealRead__isset() : value(false), status(false) {}
  bool value :1;
  bool status :1;
} _RealRead__isset;

class RealRead : public virtual ::apache::thrift::TBase {
 public:

  RealRead(const RealRead&);
  RealRead& operator=(const RealRead&);
  RealRead() : status((Status::type)0) {
  }

  virtual ~RealRead() throw();
  std::vector<double>  value;
  Status::type status;

  _RealRead__isset __isset;

  void __set_value(const std::vector<double> & val);

  void __set_status(const Status::type val);

  bool operator == (const RealRead & rhs) const
  {
    if (!(value == rhs.value))
      return false;
    if (!(status == rhs.status))
      return false;
    return true;
  }
  bool operator != (const RealRead &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const RealRead & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(RealRead &a, RealRead &b);

std::ostream& operator<<(std::ostream& out, const RealRead& obj);

typedef struct _StringRead__isset {
  _StringRead__isset() : value(false), status(false) {}
  bool value :1;
  bool status :1;
} _StringRead__isset;

class StringRead : public virtual ::apache::thrift::TBase {
 public:

  StringRead(const StringRead&);
  StringRead& operator=(const StringRead&);
  StringRead() : status((Status::type)0) {
  }

  virtual ~StringRead() throw();
  std::vector<std::string>  value;
  Status::type status;

  _StringRead__isset __isset;

  void __set_value(const std::vector<std::string> & val);

  void __set_status(const Status::type val);

  bool operator == (const StringRead & rhs) const
  {
    if (!(value == rhs.value))
      return false;
    if (!(status == rhs.status))
      return false;
    return true;
  }
  bool operator != (const StringRead &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const StringRead & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(StringRead &a, StringRead &b);

std::ostream& operator<<(std::ostream& out, const StringRead& obj);

typedef struct _BooleanRead__isset {
  _BooleanRead__isset() : value(false), status(false) {}
  bool value :1;
  bool status :1;
} _BooleanRead__isset;

class BooleanRead : public virtual ::apache::thrift::TBase {
 public:

  BooleanRead(const BooleanRead&);
  BooleanRead& operator=(const BooleanRead&);
  BooleanRead() : status((Status::type)0) {
  }

  virtual ~BooleanRead() throw();
  std::vector<bool>  value;
  Status::type status;

  _BooleanRead__isset __isset;

  void __set_value(const std::vector<bool> & val);

  void __set_status(const Status::type val);

  bool operator == (const BooleanRead & rhs) const
  {
    if (!(value == rhs.value))
      return false;
    if (!(status == rhs.status))
      return false;
    return true;
  }
  bool operator != (const BooleanRead &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const BooleanRead & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(BooleanRead &a, BooleanRead &b);

std::ostream& operator<<(std::ostream& out, const BooleanRead& obj);

typedef struct _Solver__isset {
  _Solver__isset() : name(false), settings(false) {}
  bool name :1;
  bool settings :1;
} _Solver__isset;

class Solver : public virtual ::apache::thrift::TBase {
 public:

  Solver(const Solver&);
  Solver& operator=(const Solver&);
  Solver() : name(), settings() {
  }

  virtual ~Solver() throw();
  std::string name;
  std::string settings;

  _Solver__isset __isset;

  void __set_name(const std::string& val);

  void __set_settings(const std::string& val);

  bool operator == (const Solver & rhs) const
  {
    if (!(name == rhs.name))
      return false;
    if (!(settings == rhs.settings))
      return false;
    return true;
  }
  bool operator != (const Solver &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Solver & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(Solver &a, Solver &b);

std::ostream& operator<<(std::ostream& out, const Solver& obj);

typedef struct _ModelDescription__isset {
  _ModelDescription__isset() : guid(false), fmiVersion(false), modelName(false), license(false), copyright(false), author(false), version(false), description(false), generationTool(false), generationDateAndTime(false), defaultExperiment(false), variableNamingConvention(false), modelVariables(false), modelStructure(false) {}
  bool guid :1;
  bool fmiVersion :1;
  bool modelName :1;
  bool license :1;
  bool copyright :1;
  bool author :1;
  bool version :1;
  bool description :1;
  bool generationTool :1;
  bool generationDateAndTime :1;
  bool defaultExperiment :1;
  bool variableNamingConvention :1;
  bool modelVariables :1;
  bool modelStructure :1;
} _ModelDescription__isset;

class ModelDescription : public virtual ::apache::thrift::TBase {
 public:

  ModelDescription(const ModelDescription&);
  ModelDescription& operator=(const ModelDescription&);
  ModelDescription() : guid(), fmiVersion(), modelName(), license(), copyright(), author(), version(), description(), generationTool(), generationDateAndTime(), variableNamingConvention() {
  }

  virtual ~ModelDescription() throw();
  std::string guid;
  std::string fmiVersion;
  std::string modelName;
  std::string license;
  std::string copyright;
  std::string author;
  std::string version;
  std::string description;
  std::string generationTool;
  std::string generationDateAndTime;
  DefaultExperiment defaultExperiment;
  std::string variableNamingConvention;
  ModelVariables modelVariables;
  ModelStructure modelStructure;

  _ModelDescription__isset __isset;

  void __set_guid(const std::string& val);

  void __set_fmiVersion(const std::string& val);

  void __set_modelName(const std::string& val);

  void __set_license(const std::string& val);

  void __set_copyright(const std::string& val);

  void __set_author(const std::string& val);

  void __set_version(const std::string& val);

  void __set_description(const std::string& val);

  void __set_generationTool(const std::string& val);

  void __set_generationDateAndTime(const std::string& val);

  void __set_defaultExperiment(const DefaultExperiment& val);

  void __set_variableNamingConvention(const std::string& val);

  void __set_modelVariables(const ModelVariables& val);

  void __set_modelStructure(const ModelStructure& val);

  bool operator == (const ModelDescription & rhs) const
  {
    if (!(guid == rhs.guid))
      return false;
    if (!(fmiVersion == rhs.fmiVersion))
      return false;
    if (!(modelName == rhs.modelName))
      return false;
    if (__isset.license != rhs.__isset.license)
      return false;
    else if (__isset.license && !(license == rhs.license))
      return false;
    if (__isset.copyright != rhs.__isset.copyright)
      return false;
    else if (__isset.copyright && !(copyright == rhs.copyright))
      return false;
    if (__isset.author != rhs.__isset.author)
      return false;
    else if (__isset.author && !(author == rhs.author))
      return false;
    if (__isset.version != rhs.__isset.version)
      return false;
    else if (__isset.version && !(version == rhs.version))
      return false;
    if (__isset.description != rhs.__isset.description)
      return false;
    else if (__isset.description && !(description == rhs.description))
      return false;
    if (__isset.generationTool != rhs.__isset.generationTool)
      return false;
    else if (__isset.generationTool && !(generationTool == rhs.generationTool))
      return false;
    if (__isset.generationDateAndTime != rhs.__isset.generationDateAndTime)
      return false;
    else if (__isset.generationDateAndTime && !(generationDateAndTime == rhs.generationDateAndTime))
      return false;
    if (__isset.defaultExperiment != rhs.__isset.defaultExperiment)
      return false;
    else if (__isset.defaultExperiment && !(defaultExperiment == rhs.defaultExperiment))
      return false;
    if (__isset.variableNamingConvention != rhs.__isset.variableNamingConvention)
      return false;
    else if (__isset.variableNamingConvention && !(variableNamingConvention == rhs.variableNamingConvention))
      return false;
    if (!(modelVariables == rhs.modelVariables))
      return false;
    if (!(modelStructure == rhs.modelStructure))
      return false;
    return true;
  }
  bool operator != (const ModelDescription &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const ModelDescription & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(ModelDescription &a, ModelDescription &b);

std::ostream& operator<<(std::ostream& out, const ModelDescription& obj);

typedef struct _CoSimulationAttributes__isset {
  _CoSimulationAttributes__isset() : modelIdentifier(false), canGetAndSetFMUstate(false), canSerializeFMUstate(false), providesDirectionalDerivative(false), canHandleVariableCommunicationStepSize(false), canInterpolateInputs(false), maxOutputDerivativeOrder(false) {}
  bool modelIdentifier :1;
  bool canGetAndSetFMUstate :1;
  bool canSerializeFMUstate :1;
  bool providesDirectionalDerivative :1;
  bool canHandleVariableCommunicationStepSize :1;
  bool canInterpolateInputs :1;
  bool maxOutputDerivativeOrder :1;
} _CoSimulationAttributes__isset;

class CoSimulationAttributes : public virtual ::apache::thrift::TBase {
 public:

  CoSimulationAttributes(const CoSimulationAttributes&);
  CoSimulationAttributes& operator=(const CoSimulationAttributes&);
  CoSimulationAttributes() : modelIdentifier(), canGetAndSetFMUstate(0), canSerializeFMUstate(0), providesDirectionalDerivative(0), canHandleVariableCommunicationStepSize(0), canInterpolateInputs(0), maxOutputDerivativeOrder(0) {
  }

  virtual ~CoSimulationAttributes() throw();
  std::string modelIdentifier;
  bool canGetAndSetFMUstate;
  bool canSerializeFMUstate;
  bool providesDirectionalDerivative;
  bool canHandleVariableCommunicationStepSize;
  bool canInterpolateInputs;
  int32_t maxOutputDerivativeOrder;

  _CoSimulationAttributes__isset __isset;

  void __set_modelIdentifier(const std::string& val);

  void __set_canGetAndSetFMUstate(const bool val);

  void __set_canSerializeFMUstate(const bool val);

  void __set_providesDirectionalDerivative(const bool val);

  void __set_canHandleVariableCommunicationStepSize(const bool val);

  void __set_canInterpolateInputs(const bool val);

  void __set_maxOutputDerivativeOrder(const int32_t val);

  bool operator == (const CoSimulationAttributes & rhs) const
  {
    if (!(modelIdentifier == rhs.modelIdentifier))
      return false;
    if (!(canGetAndSetFMUstate == rhs.canGetAndSetFMUstate))
      return false;
    if (!(canSerializeFMUstate == rhs.canSerializeFMUstate))
      return false;
    if (!(providesDirectionalDerivative == rhs.providesDirectionalDerivative))
      return false;
    if (!(canHandleVariableCommunicationStepSize == rhs.canHandleVariableCommunicationStepSize))
      return false;
    if (!(canInterpolateInputs == rhs.canInterpolateInputs))
      return false;
    if (!(maxOutputDerivativeOrder == rhs.maxOutputDerivativeOrder))
      return false;
    return true;
  }
  bool operator != (const CoSimulationAttributes &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const CoSimulationAttributes & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(CoSimulationAttributes &a, CoSimulationAttributes &b);

std::ostream& operator<<(std::ostream& out, const CoSimulationAttributes& obj);

}} // namespace

#endif
