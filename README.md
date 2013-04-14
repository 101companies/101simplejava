This repo is conceptually part of 101repo.

This repo containts contributions that are easy to build, run, and test.

All contributions are built using [Gradle](www.gradle.org). In order to ease deployment, a wrapper script is installed that downloads and installs gradle locally.

Go to the contributions folder:

    $ cd contributions

Run the following command:

    $ ./gradlew

Then, you can compile and test all projects by running another command:

     $ ./gradlew build

Eclipse project information can also be generated for all projects by running another command:

        $ ./gradlew eclipse

This command leaves the contributions in a state, ready to be imported into an Eclipse workspace.

NOTE: Windows users should run gradlew.bat instead from a command prompt, not from the Windows Explorer.
