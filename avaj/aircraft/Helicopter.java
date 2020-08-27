package avaj.aircraft;

import avaj.interfaces.Flyable;
import avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        System.out.println(String.format("Helicopter#%s(%d) registered to weather tower.", this.name, this.id));
    }
}
