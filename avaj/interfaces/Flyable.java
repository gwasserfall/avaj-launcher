package avaj.interfaces;

import avaj.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}