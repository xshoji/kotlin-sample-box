# janken machine by kotlin

## Build

```
$ ls -1
README.md
janken-base
janken-main
janken-root.iml
pom.xml

$ mvn package -Dmaven.test.skip=true
...
```

## Run

```
$ java -jar janken-main/target/janken-main-0.0.1-SNAPSHOT-jar-with-dependencies.jar xshoji Male Gu 20
```