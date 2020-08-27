package avaj.weather;

import avaj.aircraft.Coordinates;

import javax.swing.text.TableView;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "sun";
    }
}
