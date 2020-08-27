package avaj.aircraft;

import avaj.interfaces.Flyable;
import avaj.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        System.out.println(String.format("JetPlane#%s(%d) registered to weather tower.", this.name, this.id));
    }
}
