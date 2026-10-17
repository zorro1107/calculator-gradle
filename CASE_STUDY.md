# Gradle in the DevOps Build Cycle

## Objective

This case study demonstrates how Gradle automates the build stage of a Java 21 calculator application. The practical workflow covers dependency resolution, compilation, automated testing, reporting, executable JAR generation, and repeatable execution through the Gradle Wrapper.

## Why Gradle

Gradle uses a task graph and incremental build engine. A developer declares plugins, dependencies, toolchains, and task configuration in `build.gradle`; Gradle determines the work needed and executes tasks in dependency order. The wrapper pins the build tool version, reducing "works on my machine" differences between developers and CI agents.

## Practical workflow

1. Verify Java 21 and Gradle 8.14.5.
2. Run `gradlew.bat clean` to remove previous outputs.
3. Run `gradlew.bat compileJava` to compile production code.
4. Run `gradlew.bat test` to compile and execute eight JUnit Jupiter tests.
5. Run `gradlew.bat jar` to create the executable JAR.
6. Run `gradlew.bat build` to execute the full lifecycle verification.
7. Run the JAR with `java -jar` to prove the artifact is executable.

## Comparison and evaluation

| Criterion | Gradle | Maven | Ant |
|---|---|---|---|
| Build model | Task graph with incremental and cached work | Fixed lifecycle with plugin goals | Explicit procedural targets |
| Configuration | Groovy or Kotlin DSL | XML POM | XML build script |
| Dependency management | Built in, flexible variant-aware resolution | Built in, convention-driven | Requires Ivy or manual setup |
| Reproducible tool version | Gradle Wrapper | Maven Wrapper | No standard built-in wrapper |
| Customization | Strong, concise, programmable DSL | Reliable but plugin/XML heavy for custom work | Very flexible but highly manual |
| Best fit | Complex or performance-sensitive builds, Android, multi-project systems | Convention-heavy enterprise Java | Legacy or specialized scripted builds |

Gradle is a strong choice here because one readable build file covers the application plugin, Java 21 toolchain, JUnit dependency, test platform, and executable manifest. Maven would also handle this project well, but the equivalent custom configuration is more verbose. Ant provides fine control but requires more manual wiring and offers fewer conventions.

## DevOps value

The same wrapper command runs on a laptop and a CI server. Automated tests act as a quality gate, the HTML report provides traceability, and the versioned JAR is a deployable artifact. The build can later be connected to GitHub Actions, Jenkins, GitLab CI, or another automation server without changing the core build logic.

## Limitations and next steps

This demonstration is intentionally small and local. A production pipeline should also add static analysis, code coverage, dependency vulnerability scanning, artifact signing, and publication to a controlled repository. Build scans or remote build cache services should be enabled only after organizational privacy and access requirements are reviewed.

## References

- Gradle Java compatibility matrix: https://docs.gradle.org/current/userguide/compatibility.html
- Gradle installation guide: https://docs.gradle.org/current/userguide/installation.html
- Gradle Wrapper guide: https://docs.gradle.org/current/userguide/gradle_wrapper.html
- Gradle Java project guide: https://docs.gradle.org/current/userguide/building_java_projects.html
