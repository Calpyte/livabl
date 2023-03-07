FROM openjdk:jdk-alpine
VOLUME ["/upload"]
COPY target/livabl.jar /deployments/
# ENTRYPOINT ["sh", "-c", "java -jar -Dspring.profiles.active=dev /deployments/governance.jar"]
ENTRYPOINT ["sh", "-c", "java -jar /deployments/livabl.jar"]
# CMD java -Dspring.profiles.active=dev -jar /deployments/master.jar