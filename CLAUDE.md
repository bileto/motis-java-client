# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java client library for the MOTIS transportation information system. It uses OpenAPI Generator to create a webclient-based API client from the MOTIS OpenAPI specification.

## Build Commands

- `./gradlew build` - Build the project and generate API client
- `./gradlew openApiGenerate` - Generate Java client from OpenAPI spec
- `./gradlew test` - Run tests
- `./gradlew clean` - Clean build artifacts

## Architecture

- **Generated Client**: Located in `src/main/java`
- **Library Type**: Spring WebClient-based reactive client
- **Package Structure**:
  - `io.bileto.motis.client.api` - API interfaces
  - `io.bileto.motis.client.model` - Data models
  - `io.bileto.motis.client` - Client infrastructure

## Dependencies

- Spring WebFlux for reactive HTTP client
- Jackson for JSON serialization
- Reactor Netty for HTTP transport
- JUnit 5 for testing

## OpenAPI Generation

The client is automatically generated from `ext/motis/openapi.yaml` during compilation. The generator uses the webclient library template for Spring WebFlux integration.