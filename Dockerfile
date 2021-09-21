FROM  openjdk:16
COPY ./target/employee-management-system-0.0.1-SNAPSHOT.jar employee-management-system-0.0.1-SNAPSHOT.jar
ENV BAMBOO_AUTHENTICATION Authentication
ENV KIMAI_USERNAME Username
ENV KIMAI_PASSWORD Password
EXPOSE 8080
ENTRYPOINT ["java","-jar","employee-management-system-0.0.1-SNAPSHOT.jar"]



