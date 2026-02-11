# MOTIS (Journey Planner) API Java Client

## Versioning

[Semantic versioning](https://semver.org/) is not applied. MOTIS API Java Client matches versioning of the [MOTIS](https://github.com/motis-project/motis) itself. Major, minor, and patch version correspond to the release of MOTIS `openapi.yaml`, and forth number is iteration of releases for given MOTIS version.

## Build

The code is generated from the MOTIS openapi specification. Git submodule `ext/motis` links the MOTIS project at the time of code generation.

In order to sync local MOTIS repo with the commit specified in project, run
```shell
git submodule update --init --recursive
```

In order to download given tag version of MOTIS changes, run following commands:

```shell
cd ext/motis
git fetch --tags
git checkout tags/vX.X.X
```

To generate code based on the current `ext/motis/openapi.yaml`, run

```shell
gradle openApiGenerate
```

Once the code is generated, you can build it using Gradle.

```shell
gradle build
```

## Publishing to GitHub Packages

This project is configured to publish to GitHub Packages. To publish manually:

1. Set up environment variables:
   ```shell
   export GITHUB_USERNAME=your-github-username
   export GITHUB_TOKEN=your-github-personal-access-token
   ```

2. Run the `publish` task:
   ```shell
   ./gradlew publish
   ```

### GitHub Personal Access Token

You need a GitHub Personal Access Token with the following permissions:
- `write:packages`
- `read:packages`

Generate one at: https://github.com/settings/tokens

### Automatic Publishing

The project includes a GitHub Actions workflow that automatically publishes:
- On pushes to the `master` branch
- When a new release is created

## Using the Published Package

To use this package in another project, add the following to your `build.gradle`:

```gradle
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/bileto/motis-java-client")
        credentials {
            username = System.getenv("GITHUB_USERNAME") ?: project.findProperty("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation 'dev.bileto:motis-java-client:1.2.3.4'
}
```
