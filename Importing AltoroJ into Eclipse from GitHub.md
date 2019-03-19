# Importing AltoroJ into Eclipse from GitHub

This is a short guide on setting up your environment to run AltoroJ inside Eclipse.


#1. Download and install required components
Here's what you'll need...
- Eclipse Oxygen (4.7) - note whether you are downloading a 32-bit or 64-bit version
- Java JDK 7 or later - ensure it is 64-bit if your OS and Eclipse are 64-bit)
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
- Create a new Apache Tomcat v7.0 Server. Tomcat installation directory is where you installed/extracted your Apache Tomcat instance


#4. Pull down AltoroJ from GitHub
- Go to File -> Import -> Git -> Projects from Git
- Choose "Clone URI" and use the following URI on the next screen: https://github.com/AppSecDev/AltoroJ/
- Optionally, specify your Github username and password if you have one. This is not required.
- Proceed through the wizard without making any changes until you get to Wizard for Project import. At this point, choose to "Import existing Eclipse projects" and then continue through and finish the wizard


#5. Fix build issues
When you import a project into Eclipse, Eclipse will automatically modify a preferences file, which will break AltoroJ. If this happens to you, here's what to do...

- Right-click on your AltoroJ project in Eclipse's Project Explorer
- Go to Replace With -> Index
- Click OK on the Discard Local Changes dialog

This should fix majority of build issues you'll encounter.


#6. Run AltoroJ
- Right-click on your AltoroJ project in Eclipse's Project Explorer
- Choose Run As -> Run On Server
- Select your Apache Tomcat v7.0 Server instance and click Finish
- AltoroJ should now come up in a built-in web browser
- Confirm that AltoroJ is properly initialized by logging in using the following credentials:
Username: jsmith
Password: demo1234

That's it!
