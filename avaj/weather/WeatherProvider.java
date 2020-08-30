package avaj.weather;

import avaj.aircraft.Coordinates;

import java.util.Random;


public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    protected String[] weather = {"SUN", "RAIN", "FOG", "SNOW" };

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int random = new Random().nextInt(4);
        return weather[random];
    }
}
