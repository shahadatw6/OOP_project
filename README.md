# OOP_project
It is for a car shop
Download the project and open it in apache netbeans .
You will need java 8


Installing Open JDK 8 on Debian or Ubuntu Systems
Configure your operating system to use the latest build of a Technology Compatibility Kit (TCK) Certified OpenJDK version 8, such as OpenJDK 8 (1.8.0_151 minimum). Java 9 and later are not supported.
Note: After installing the JDK, you may need to set JAVA_HOME to your profile:
For shell or bash: export JAVA_HOME=path_to_java_home
For csh (C shell): setenv JAVA_HOME=path_to_java_home



These instructions show you how to install OpenJDK. DataStax has tested OpenJDK at scale.
Check which version of the JDK your system is using:


    java -version

    
If the OpenJDK is used, the results should look like:

    openjdk version "1.8.0_242"
    OpenJDK Runtime Environment (build 1.8.0_242-b09)
    OpenJDK 64-Bit Server VM (build 25.242-b09, mixed mode)
    
If Oracle Java is used, the results should look like:

    java version "1.8.0_241"
    Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
    Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
    
Update the repositories:

    sudo apt-get update
    
Install OpenJDK:

    sudo apt-get install openjdk-8-jdk

    
The latest JDK is installed.

Verify the version of the JDK:

    java -version

    
    openjdk version "1.8.0_242"
    OpenJDK Runtime Environment (build 1.8.0_242-b09)
    OpenJDK 64-Bit Server VM (build 25.242-b09, mixed mode)

    
If the correct version of Java is not being used, use the alternatives command to switch it:

    sudo update-alternatives --set java /usr/lib/jvm/jdk1.8.0_version/bin/java
    
Verify the version of the JDK:

    java -version
    openjdk version "1.8.0_242"
    OpenJDK Runtime Environment (build 1.8.0_242-b09)
    OpenJDK 64-Bit Server VM (build 25.242-b09, mixed mode)
