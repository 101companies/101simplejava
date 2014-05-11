# Summary

This repo is conceptually part of [101repo](http://101companies.org/wiki/101companies:Repository).

This repo contains Java-based contributions that are easy to build, run, and test.

The physical location of this repo is here:

https://github.com/101companies/101simplejava/

The master ZIP file for the repo is this one:

https://github.com/101companies/101simplejava/archive/master.zip

The GIT URL for cloning and forking is this one:

git://github.com/101companies/101simplejava.git

# Prerequisites

* Java SDK 6+ (with Java SDK binaries in the PATH or JAVA_HOME set up)
* Eclipse Juno+ (in case contributions are to be opened in Eclipse)

# Building information

All contributions are built using [Gradle](www.gradle.org), check [this site](hhttp://www.gradle.org/tooling) for an offical plugin for your IDE. 

When using an offical Plugin, just download this repo and import the contributions with your IDE.

# Building contributions

In order to ease deployment, a wrapper script downloads and installs Gradle locally.

The following instructions are for users with Unix/Linux-like OSs. See instructions for Window users below. 

Go to the contributions folder:

    $ cd contributions

Run the following command, which downloads Gradle if needed and performs possibly other preparations:

    $ ./gradlew

Then, run another command to build and test all contributions:

    $ ./gradlew build

If this approach fails, it may be that there is an issue with a particular contribution which takes down the entire build step. Perhaps, this problematic contribution is not even of interest for you. In this case, you could just try to build the contributions of interest individually, as described below.
    
# Preparing contributions for Eclipse

Eclipse project information can be generated for all projects by running another command:

    $ ./gradlew eclipse

This command leaves the contributions in a state ready to be imported into an Eclipse workspace.

You can use the [Gradle-Eclipse-Plugin](https://github.com/spring-projects/eclipse-integration-gradle/) instead.

# Exercising individual contributions

You may also run Gradle selectively to build individual contributions.

First, make sure that you ran Gradle like this (just as before):

    $ cd contributions
    $ ./gradlew

Then, go to the folder of the specific contribution, e.g.:

    $ cd javaComposition

Then, run the following command to build and test the contribution:

    $ ../gradlew build

# Special notes on Windows

Use the batchfile "gradlew.bat" instead of the script "gradlew".

Run the batchfile from a command prompt with "gradlew" instead of "./gradlew" as explained above, not from the Windows Explorer.

The "../gradlew" command doesn't work on windows.

Check that JDK binaries are in your PATH and/or the JAVA_HOME environment variable is set.

http://stackoverflow.com/questions/2619584/how-to-set-java-home-on-windows-7
