package org.vepo.modular.weather.yahoo;

import org.vepo.modular.weather.Weather;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class WeatherYahoo implements Weather {

	public String getName() {
		return "Yahoo";
	}

	public String getWeather(String cityName) {
		try {
			return Unirest.get("https://query.yahooapis.com/v1/public/yql").queryString("format", "json")
					.queryString("env", "store://datatables.org/alltableswithkeys")
					.queryString("q", String.format(
							"select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")",
							cityName))
					.asString().getBody();
		} catch (UnirestException e) {
			throw new RuntimeException(e);
		}
	}
}