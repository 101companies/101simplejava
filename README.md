This is a de-centralized repo for 101companies contributions.

The repo containts contributions that are easy to build, run, and test.

All contributions are built using [Gradle](www.gradle.org). In order to ease deployment, a wrapper script is installed that downloads and installs gradle locally. Just run

    $ ./gradlew

from the contributions folder. Then you can compile and test all projects by running

     $ ./gradlew build

Eclipse project information can also be generated for all projects by typing

        $ ./gradlew eclipse

which leaves the contributions in a state, ready to be imported into an Eclipse workspace.

NOTE: Windows users should run gradlew.bat instead from a command prompt, not from the Windows Explorer.

See the wiki for the 101companies/101repo github repo for further information.
