package avaj.aircraft;

import avaj.interfaces.Flyable;
import avaj.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        System.out.println(String.format("Baloon#%s(%d) registered to weather tower.", this.name, this.id));
    }
}
