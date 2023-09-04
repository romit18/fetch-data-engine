
This application has been built as a microservice which when triggered/started will run every 10s to read messages from the SQS queue and store it in the DB. 

You would need Java 17 on your system for running the application.

Micronaut JMS is something to which this application can be extended shortening the code a lot if an actual AWS account can be used. 

I have used base64 encoding/decoding for masking. 
## Micronaut 4.1.0 Documentation

- [User Guide](https://docs.micronaut.io/4.1.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.1.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.1.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)

## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)

## Feature jms-sqs documentation

- [Micronaut AWS SQS JMS Messaging documentation](https://micronaut-projects.github.io/micronaut-jms/snapshot/guide/index.html)

## Feature jms-core documentation

- [Micronaut JMS documentation](https://micronaut-projects.github.io/micronaut-jms/snapshot/guide/index.html)


