# MOTIS (Journey Planner) API Java Client

## Build

The code is generated from the MOTIS openapi specfication. Git submodule `ext/motis` links the MOTIS project at the time of code generation.

In order to download latest MOTIS changes, run 

```shell
git submodule foreach git pull origin master
```

To generate code based on the current `ext/motis/openapi.yaml`, run

```shell
gradle openApiGenerate
```

Once the code is generated, you can build it using Gradle.

```shell
gradle build
```
