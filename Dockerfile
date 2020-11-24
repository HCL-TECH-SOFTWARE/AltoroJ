FROM debian:jessie

MAINTAINER Joel Rousseau <v4lproik@gmail.com>

ENV TOMCATVER 7.0.73

RUN (apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y openjdk-7-jre-headless wget)
RUN (wget -O /tmp/tomcat7.tar.gz http://archive.apache.org/dist/tomcat/tomcat-7/v${TOMCATVER}/bin/apache-tomcat-${TOMCATVER}.tar.gz && \
  cd /opt && \
  tar zxf /tmp/tomcat7.tar.gz && \
  mv /opt/apache-tomcat* /opt/tomcat && \
  rm /tmp/tomcat7.tar.gz)

ADD ./bin/run.sh /usr/local/bin/run

RUN rm -rf /opt/tomcat/webapps/docs /opt/tomcat/webapps/examples /opt/tomcat/webapps/ROOT
ADD ["AltoroJ 3.1.1/build/libs/altoromutual.war", "/opt/tomcat/webapps/ROOT.war"]

EXPOSE 8080

CMD ["/usr/local/bin/run"]
