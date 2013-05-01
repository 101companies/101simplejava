# Summary

This repo is conceptually part of [101repo](http://101companies.org/wiki/101companies:Repository).

This repo contains Java-based contributions that are easy to build, run, and test.

The physical location of this repo is here:

https://github.com/101companies/101simplejava/

This is also where the repo can be downloaded (see the ZIP button).

This is also where the GIT URL is published for cloning or forking the repo.

# Prerequisites

* Java SDK 6+ (with Java SDK binaries in the PATH)
* Eclipse Juno+ (in case contributions are to be opened in Eclipse)

# Building contributions

All contributions are built using [Gradle](www.gradle.org).

In order to ease deployment, a wrapper script downloads and installs Gradle locally.

The following instructions are for users with Unix/Linux-like OSs. See instructions for Window users below. 

Go to the contributions folder:

    $ cd contributions

Run the following command, which downloads Gradle if needed and performs possibly other preparations:

    $ ./gradlew

Then, run another command to build and test all contributions:

    $ ./gradlew build
    
# Preparing contributions for Eclipse

Eclipse project information can be generated for all projects by running another command:

    $ ./gradlew eclipse

This command leaves the contributions in a state ready to be imported into an Eclipse workspace.

# Exercising individual contributions

You may also run Gradle selectively to build individual contributions.

First make sure that you ran Gradle like this at the top:

    $ cd contributions
    $ ./gradlew

Then, go to the folder of the specific contribution, e.g.:

    $ cd javaComposition

Then, run the following command to build and test the contribution:

    $ ../gradlew build

# Special notes on Windows

Windows users should run gradlew.bat instead from a command prompt, not from the Windows Explorer. You might also want to check if your JAVA_HOME environment variable is set. Up to Windows 7, you can check on your JAVA_HOME variable [like this](http://stackoverflow.com/questions/2619584/how-to-set-java-home-on-windows-7).
