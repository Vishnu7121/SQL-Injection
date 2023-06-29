FROM tomcat:9.0.58-jdk17-openjdk-slim
COPY ./dist/test.war /usr/local/tomcat/webapps
