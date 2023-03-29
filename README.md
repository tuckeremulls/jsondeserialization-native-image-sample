# @JsonDeserialization(using=...) Native Image Sample Testing

- Encountering that when @JsonDeserialization with a custom deserializer is used to deserialize a field from a response 
  JSON of a WebClient call (when run as a native image), the following exception is encountered: 
  `No default constructor found with root cause`
  
- Using an API to call itself is obviously not a good practice of design patterns and is only used in this project as a 
  quick and self-contained example.
  
- Steps to reproduce the issue:
    - `mvn -Pnative spring-boot:build-image`
    - `docker run --rm -p 8080:8080 -d docker.io/library/jsondeserialization-exception-native:1.0.0`
    - `curl http://localhost:8080/sendwebclientrequest`
