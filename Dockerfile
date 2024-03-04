FROM tomcat:7
USER root

ADD https://github.com/HCL-TECH-SOFTWARE/AltoroJ/releases/download/v3.4/altoromutual.war /usr/local/tomcat/webapps
EXPOSE 8080

CMD /usr/local/tomcat/bin/catalina.sh run
