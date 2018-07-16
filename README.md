# Modularity in Java

This is a very simple HOW TO build a modular application in Java.

## Why?

Why use modularity?  

* Low coupling

## Step 1: Define the API

Look `weather` module. There is only a `Weather` interface. Nothing more! This is all you need to define a module in Java.

## Step 2: Implement the API

Look the modules `weather-yahoo` and `weather-open-weather-map` modules. Both has his onw implementation of `Weather` interface. This is only a simple implementation, means nothing. Now it is need to inform the JVM that this interface implements a service. Look in both modules the `src/resources/META-INF/services/org.vepo.modular.weather.Weather`, this file will tell to JVM what class implements the `Weather` interface. Simple?

## Step 3: Use it

Look the `CLIApp` class. Using the `ServiceLoader`, you can load all implementation of the requested service.

```
ServiceLoader<Weather> loader = ServiceLoader.load(Weather.class);
```


## To Execute without maven

```
java -cp cli-1.0-SNAPSHOT.jar:weather-yahoo-1.0-SNAPSHOT.jar:weather-1.0-SNAPSHOT.jar:weather-open-weather-map-1.0-SNAPSHOT.jar:/home/victor/.m2/repository/com/mashape/unirest/unirest-java/1.4.9/unirest-java-1.4.9.jar:/home/victor/.m2/repository/org/apache/httpcomponents/httpclient/4.5.2/httpclient-4.5.2.jar:/home/victor/.m2/repository/org/apache/httpcomponents/httpcore/4.4.4/httpcore-4.4.4.jar:/home/victor/.m2/repository/org/apache/httpcomponents/httpcore-nio/4.4.4/httpcore-nio-4.4.4.jar:/home/victor/.m2/repository/org/apache/httpcomponents/httpasyncclient/4.1.1/httpasyncclient-4.1.1.jar:/home/victor/.m2/repository/org/apache/httpcomponents/httpmime/4.5.2/httpmime-4.5.2.jar:/home/victor/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar org.vepo.modular.cli.CLIApp -Dexec.args="São Paulo"
```

That was we call **Classpath Hell**.