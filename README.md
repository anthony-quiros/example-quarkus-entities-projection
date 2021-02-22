# trpc-notificationEditor project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
- Create a postegres database
```shell script
docker run --name postgres-quarkus-test --env POSTGRES_PASSWORD=admin --publish 5432:5432 --detach postgres && sleep 5 && psql 'postgresql://postgres:admin@localhost'  -c 'CREATE DATABASE quarkus;'
```
- Start quarkus
```shell script
./mvnw compile quarkus:dev
```

- Stop and remove postegres database
```shell script
docker container stop postgres-quarkus-test && docker container rm postgres-quarkus-test
```

To add some data in the database
```
http://localhost:8080/init
```

To get the list of pepole
```
http://localhost:8080/people
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `trpc-notificationEditor-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/trpc-notificationEditor-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/trpc-notificationEditor-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy Reactive

<p>A Hello World RESTEasy Reactive resource</p>

Guide: https://quarkus.io/guides/getting-started-reactive
