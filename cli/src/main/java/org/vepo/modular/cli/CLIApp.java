package org.vepo.modular.cli;

import org.vepo.modular.weather.Weather;
import java.util.ServiceLoader;

public class CLIApp {
	public static void main(String... args) {

		ServiceLoader<Weather> loader = ServiceLoader.load(Weather.class);
		for (Weather weather : loader) {
			System.out.println("Querying on: " + weather.getName());
			System.out.println("Response: " + weather.getWeather(args[0]));
		}
	}
}