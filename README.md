# Assignment 1 - Builder Pattern

## Course
Software Design Patterns

## Domain
Computer Configuration

## Individual Variant
Constraint: RTX 4090 requires at least 850W power supply.

Required Preset: PERFORMANCE

## Description
This project demonstrates the Builder Design Pattern using a computer configuration system.

A Computer has required and optional properties. The Builder provides a fluent API that allows a computer to be constructed step by step.

## Required Properties
- Processor
- GPU
- RAM
- Storage

## Optional Properties
- Power Supply
- Wi-Fi
- Bluetooth
- RGB
- Liquid Cooling
- Operating System

## Presets
The project contains three preset configurations:

- BASIC
- GAMING
- PERFORMANCE

## Validation
The Builder validates the configuration before creating the final Computer object.

Examples:
- Processor cannot be null.
- GPU cannot be empty.
- RAM must be at least 4 GB.
- Storage must be at least 128 GB.
- RTX 4090 requires at least 850W PSU.
- 64 GB or more RAM requires at least 600W PSU.

## Testing
The project contains 10 automated JUnit 5 tests:

- 3 valid construction scenarios
- 3 invalid construction scenarios
- 2 boundary cases
- 1 individual constraint test
- 1 Builder reuse / Product independence test

## Technologies
- Java JDK 17+
- JUnit 5
- Git
- GitHub