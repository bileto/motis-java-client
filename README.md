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

## Publishing to GitHub Packages

This project is configured to publish to GitHub Packages. To publish manually:

1. Set up environment variables:
   ```shell
   export GITHUB_USERNAME=your-github-username
   export GITHUB_TOKEN=your-github-personal-access-token
   ```

2. Run the publish task:
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
            username = System.getenv("GITHUB_USERNAME") ?: project.findProperty("gpr.user")
            password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("gpr.key")
        }
    }
}

dependencies {
    implementation 'com.bileto:motis-java-client:0.0.0-SNAPSHOT'
}
```
