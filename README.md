AstroExplorer
---

### Development Installation

To get started on developing this project, clone the repository, and import the
project using your preferred IDE. If you are running without an IDE, or one
without built-in Gradle support, you can use the bundled Gradle wrapper to build
and run the project:

    git clone https://github.com/ooagroup/astroexplorer.git
    cd astroexplorer
    ./gradlew run

If you are using IntelliJ, clone the repository, then use the import tool to
import the project by selecting the `build.gradle` file contained within this
repository. You can do this by going to the IntelliJ welcome window, and
selecting **Import Project**. This will bring up a dialogue that contains a file
selector. Use this to select `astroexplorer/build.gradle`, wherever you have
cloned the repository. Proceed to the next window, ensure **Use auto-import**
and **Use default gradle wrapper** are checked, then click **OK**. You can leave
all other settings on the page the same as you found them. Once the build
process completes for the first time, you will be able to run the application.


### Running the Application

To run the application standalone, you can use the following command:

    gradle run

If you are using IntelliJ, then you will want to open the Gradle tools. You can
find them by navigating through the following panes:

    View -> Tool Windows -> Gradle

This will open a toolbar on the right side of your screen that contains an entry
for each defined Gradle task. To run the application, expand **Tasks**, then
**application**, and double click **run**. This should launch the application.

### File Structure

The project follows a file structure as defined by Gradle conventions. The are
as marked below:

    build                   # class files and others generated on build
    src/main/java           # primary application source files
    src/test/java           # the associated unit tests for the application

The primary entry point as passed off to `gradle run` is defined in the main
build file (`build.gradle`) and is currently defined as `HelloWorld`.
