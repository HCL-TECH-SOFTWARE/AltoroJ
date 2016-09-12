# Description
WARNING: This application contains security vulnerabilities. Run it only in a sheltered environment (such as a VM with host-only networking) and at your own risk, escpecially if you enable some of the advanced options described below!

AltoroJ is a sample banking J2EE web application. It shows what happens when web applications are written with consideration of app functionality but not app security. It's a simple and uncluttered platform for demonstrating and learning more about real-life application security issues.

AltoroJ uses standard Java & JSP functionality without relying on any additional frameworks. While vast majority of real-life applications do use frameworks, the exact same principles of Application Security apply in both cases. Frameworks can also be hard to understand for someone not familiar with a particular framework and introduce complexities that detract from the overall learning experience. Not to mention, a large number of large and complex "legacy" Java web applications that look very similar to AltoroJ (but are infinitely more complex of course).

AltoroJ uses Apache Derby as its SQL database that is automatically initialized the first time you log into AltoroJ via its web interface. All of the transactions and operations will then be stored in this database from that point on until you delete your repository folder called "altoro" that is located in your OS home folder (e.g. C:\Users\[your_username] or /Users/[your_username]) or enable advanced option to re-initialize your database every time your web application server is restarted (see below).


# Prereqiusites
AltoroJ has been developed using Eclipse and designed to run on Tomcat 7, but since it's a relatively simple J2EE app, it should be pretty easy to port it to a different J2EE IDE or another J2EE web application server. Here are out-of-the-box requirements:

- Eclipse 4.3 or newer
- Tomcat 7.x
- Gradle 3.0 and Gradle's Buildship Eclipse plug-in to automatically download required 3rd party libraries and build AltoroJ


# AltoroJ credentials
Main usernames and passwords for AltoroJ are as follows:
jsmith/demo1234
admin/admin



# Advanced options
