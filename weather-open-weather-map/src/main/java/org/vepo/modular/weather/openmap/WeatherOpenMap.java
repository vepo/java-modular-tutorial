package org.vepo.modular.weather.openmap;

import org.vepo.modular.weather.Weather;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class WeatherOpenMap implements Weather {

	public String getName() {
		return "Open Weather Map";
	}

	public String getWeather(String cityName) {
		try {
			return Unirest.get("http://api.openweathermap.org/data/2.5/weather")
					.queryString("APPID", "dad8b6b8c77122ae8b361c00982dc38a").queryString("q", cityName).asString()
					.getBody();
		} catch (UnirestException e) {
			throw new RuntimeException(e);
		}
	}
}