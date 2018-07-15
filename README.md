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