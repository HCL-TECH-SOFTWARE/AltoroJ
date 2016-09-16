# Importing AltoroJ into Eclipse from GitHub

This is a short guide on setting up your environment to run AltoroJ inside Eclipse.

#1. Download and install required components
Here's what you'll need...
- Eclipse Neon (4.6) - note whether you are downloading a 32-bit or 64-bit version
- Java JDK 8 - ensure it is 64-bit if your OS and Eclipse are 64-bit)
- The latest build of Apache Tomcat 7.x. Ensure you're downloading Tomcat 7 and not one of the newer versions as they have not been tested and may not work
- Gradle 3.0 if you'd like to compile AltoroJ from command line

Install Java first, then Tomcat, then Eclipse. Install Gradle any time.

#2. Install Gradle Buildship
- Open Eclipse (create a workspace if you don't have one)
- Got to Help -> Eclipse Marketplace
- Search for Buildship
- Install Buildship Gradle Integration and restart Eclipse


#3. Add Tomcat Server to Eclipse
- Open Servers view (Window -> Show View -> Other -> Servers)
- Create a new Apache Tomcat v7.0 Server. Tomcat installation directory is where you installed/extracted your tomcat instance

#4. Pull down AltoroJ from GitHub


