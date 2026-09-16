# Assignment 1 - Builder Pattern

## 1. Problem Description

The project represents a computer configuration system.

A Computer contains many required and optional parameters.
Using one traditional constructor makes the code difficult to read,
maintain, validate, and extend.

## 2. Individual Variant

Domain: Computer Configuration

Constraint:
RTX 4090 requires at least 850W power supply.

Required Preset:
PERFORMANCE

## 3. Initial Constructor-Based Solution

Initially, Computer was created using a constructor with many parameters.

Example:

Computer computer = new Computer(
processor,
"RTX 4070",
32,
1000,
750,
true,
true,
true,
true,
"Windows 11"
);

### Problems

1. Boolean values such as true and false are difficult to understand.
2. Parameters of similar types can easily be passed in the wrong order.
3. Adding new optional properties makes the constructor larger and harder to maintain.

The initial constructor implementation is preserved in the Git development history.

## 4. Builder Solution

The constructor-based implementation was refactored using the Builder Design Pattern.

Example:

Computer computer =
new Computer.Builder(
processor,
"RTX 4070",
32,
1000
)
.withPowerSupply(750)
.enableWifi()
.enableBluetooth()
.enableRgb()
.withLiquidCooling()
.withOperatingSystem("Windows 11")
.build();

The Builder allows the Computer to be constructed step by step.

The fluent API makes the client code easier to read.

## 5. Builder Participants

Product:
Computer

Builder:
Computer.Builder

Client:
Main

Preset Provider:
ComputerPresets

Value Object:
Processor

## 6. Validation Rules

The Builder validates the configuration before creating the Computer.

### Single-field validation

1. Processor cannot be null.
2. GPU cannot be null or empty.
3. RAM must be at least 4 GB.
4. Storage must be at least 128 GB.

### Cross-field validation

1. RTX 4090 requires at least 850W PSU.
2. A configuration with 64 GB or more RAM requires at least 600W PSU.

Validation is performed before construction so an invalid Computer
cannot be created.

## 7. Preset Configurations

Three reusable configurations are implemented.

### BASIC
A simple computer for everyday tasks.

### GAMING
A gaming computer with RTX 4070, RGB, Wi-Fi and liquid cooling.

### PERFORMANCE
A high-performance computer with RTX 4090, 64 GB RAM,
and a 1000W power supply.

PERFORMANCE is the required preset for this individual variant.

## 8. Clean Code - Before and After

### Example 1 - Avoid Flag Arguments

BEFORE:

Computer computer = new Computer(
processor,
"RTX 4070",
32,
1000,
750,
true,
true,
true,
true,
"Windows 11"
);

Problem:
The meaning of each boolean value is not clear.

AFTER:

new Computer.Builder(processor, "RTX 4070", 32, 1000)
.enableWifi()
.enableBluetooth()
.enableRgb()
.withLiquidCooling()
.build();

Principle:
Avoid flag arguments and use descriptive naming.

Why it is better:
The intention of every configuration step is clear.

### Example 2 - Small Functions

BEFORE:

Validation and construction logic can be placed together
inside one large method.

AFTER:

public Computer build() {
validate();
return new Computer(this);
}

Principles:
Small functions and one function - one responsibility.

Why it is better:
build() is responsible for building the object,
while validate() is responsible for validation.

### Example 3 - Descriptive Naming

BEFORE:

setWifi(true);
setRgb(true);

AFTER:

enableWifi();
enableRgb();

Principle:
Descriptive naming.

Why it is better:
The method name clearly describes the operation.

### Clean Code Principles Used

- Small functions
- One function - one responsibility
- Descriptive naming
- Avoiding flag arguments
- DRY
- Clear error handling

## 9. Design Decision

Decision:
Computer is immutable after construction.

The Computer fields are final and the object does not provide setters.

Alternative:
Make Computer mutable and allow properties to be changed using setters.

Reasoning:
The mutable alternative was rejected because a valid Computer
could become invalid after it was created.

The Builder collects the configuration, validates it,
and creates a final immutable Computer.

## 10. UML Traceability

| Builder Role | Class | Responsibility |
|---|---|---|
| Product | Computer | Stores the final computer configuration |
| Builder | Computer.Builder | Builds and validates Computer |
| Client | Main | Uses Builder and preset configurations |
| Preset Provider | ComputerPresets | Creates reusable configurations |
| Value Object | Processor | Represents CPU brand and model |

## 11. Automated Testing

The project contains 10 automated JUnit 5 tests.

Tests include:

- 3 valid construction scenarios
- 3 invalid construction scenarios
- 2 boundary cases
- 1 individual constraint test
- 1 Builder reuse / Product independence test

The Builder reuse test demonstrates that changing and reusing
a Builder does not modify a Computer that was already built.

All 10 tests pass successfully.

## 12. Sample Program Output

The application creates three configurations:

BASIC

GAMING

PERFORMANCE

The console output contains the required banana symbol
for exactly one successfully built configuration:

🍌

## 13. Git Development History

The project was developed incrementally using meaningful Git commits.

Main development stages:

1. Initial constructor-based model
2. Refactoring to Builder Pattern
3. Validation rules
4. Preset configurations
5. Automated tests
6. Documentation and UML

## 14. GitHub Repository

Repository link:

ADD_GITHUB_REPOSITORY_LINK_HERE