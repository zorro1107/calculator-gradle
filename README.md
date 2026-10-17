# Gradle Java Calculator

This project demonstrates Gradle in the DevOps build stage with a Java 21 command-line calculator. Gradle resolves JUnit Jupiter, compiles production and test code, runs automated tests, generates an HTML test report, and packages an executable JAR.

## Requirements

- JDK 21
- Internet access on the first build so the Gradle Wrapper and Maven Central dependencies can be downloaded
- No global Gradle installation is required after the wrapper is included

## Project layout

```text
calculator-gradle/
|-- build.gradle
|-- settings.gradle
|-- gradlew / gradlew.bat
|-- gradle/wrapper/
|-- src/main/java/com/example/calculator/
|   |-- Calculator.java
|   `-- CalculatorApp.java
`-- src/test/java/com/example/calculator/
    `-- CalculatorTest.java
```

## Build commands on Windows

```powershell
.\gradlew.bat clean
.\gradlew.bat compileJava
.\gradlew.bat test
.\gradlew.bat jar
.\gradlew.bat build
java -jar .\build\libs\calculator-gradle-1.0.0.jar 12 multiply 4
```

Expected application output:

```text
12 multiply 4 = 48
```

The test report is generated at `build/reports/tests/test/index.html`. The executable artifact is generated at `build/libs/calculator-gradle-1.0.0.jar`.

## Build configuration summary

- `application` plugin defines the executable entry point.
- Java toolchains require Java 21 for consistent compilation.
- Maven Central supplies JUnit Jupiter 5.10.2 and the JUnit Platform launcher.
- `useJUnitPlatform()` enables JUnit 5 discovery and execution.
- The `jar` task writes the `Main-Class` manifest attribute.

## Continuous integration example

A CI agent can run `gradlew.bat clean build` on Windows or `./gradlew clean build` on Linux. A failed compilation or test returns a non-zero exit code, so the pipeline stops before publishing a bad artifact.
