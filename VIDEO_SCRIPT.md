# Short Video Demonstration Script

## Target length 3 to 4 minutes

**Opening - 20 seconds**

"This case study demonstrates Gradle in the DevOps build stage. The sample is a Java 21 calculator with automated JUnit tests, an executable JAR, and a Gradle Wrapper so the build uses the same Gradle version on every machine."

**Environment and structure - 35 seconds**

Show `java -version` and `gradlew.bat --version`, then show the project tree. Explain that Java 21 is the compiler/runtime and Gradle 8.14.5 is pinned by the wrapper. Point out `src/main`, `src/test`, `build.gradle`, and the wrapper files.

**Build file - 40 seconds**

Open `build.gradle`. Highlight the application plugin, Maven Central, Java 21 toolchain, JUnit Jupiter dependency, `useJUnitPlatform()`, and the JAR manifest entry that makes `java -jar` work.

**Compilation and testing - 55 seconds**

Run `gradlew.bat clean`, `gradlew.bat compileJava`, and `gradlew.bat test`. Explain that Gradle downloads dependencies on the first run, compiles source sets, and executes eight tests. Open the generated HTML report and show that all tests passed.

**Artifact generation - 40 seconds**

Run `gradlew.bat jar` and `gradlew.bat build`. Show `build/libs/calculator-gradle-1.0.0.jar`. Explain that `build` is the lifecycle command a CI server would normally execute and that it stops on compilation or test failure.

**Run and conclusion - 35 seconds**

Run `java -jar build/libs/calculator-gradle-1.0.0.jar 12 multiply 4`. Show the result `12 multiply 4 = 48`. Conclude that Gradle automated dependency resolution, compilation, testing, reporting, and packaging in a repeatable workflow.
