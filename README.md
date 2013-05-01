This repo is conceptually part of 101repo.

This repo contains Java-based contributions that are easy to build, run, and test.

This repo can be downloaded from here; see ZIP button:

https://github.com/101companies/101simplejava/

This is also where you find the GIT URI for cloning or forking the repo.

Java SDK 6+ is assumed. Java SDK binaries (such as javac) must be in the PATH. All contributions are built using [Gradle](www.gradle.org). In order to ease deployment, a wrapper script is installed that downloads and installs gradle locally.

Go to the contributions folder:

    $ cd contributions

Run the following command:

    $ ./gradlew

Then, you can compile and test all projects by running another command:

    $ ./gradlew build

Eclipse project information can also be generated for all projects by running another command:

    $ ./gradlew eclipse

This command leaves the contributions in a state, ready to be imported into an Eclipse workspace.

NOTE: Windows users should run gradlew.bat instead from a command prompt, not from the Windows Explorer. You might also want to check if your JAVA_HOME environment variable is set. Up to Windows 7, you can check on your JAVA_HOME variable [like this](http://stackoverflow.com/questions/2619584/how-to-set-java-home-on-windows-7).

If you want to build just a specific contribution, descend into that contributions directory, e.g.

    $ cd contributions/antlrAcceptor

and run the gradlew script from there, i.e.

    $ ../gradlew build
