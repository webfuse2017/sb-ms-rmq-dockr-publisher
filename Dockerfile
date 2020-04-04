From openjdk:8
copy ./target/publisher-0.0.1-SNAPSHOT.jar publisher.jar
CMD ["java","-jar","publisher.jar"]