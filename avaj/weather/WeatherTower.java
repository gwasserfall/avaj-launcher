package avaj.weather;

import avaj.aircraft.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getProvider();

        return weatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }
}
