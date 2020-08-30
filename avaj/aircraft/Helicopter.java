package avaj.aircraft;

import avaj.interfaces.Flyable;
import avaj.simulation.Simulation;
import avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String msg = String.format("Helicopter#%s(%d): ", this.name, this.id);
        int newLng = this.coordinates.getLongitude();
        int newLat = this.coordinates.getLatitude();
        int newHgt = this.coordinates.getHeight();

        if (weather.equals("SUN")) {
            newLng += 10;
            newHgt += 2;
            msg += "Sunny skies, best skies.";
        }
        else if (weather.equals("RAIN")) {
            newLng += 5;
            msg += "Rain is no match for us.";
        }
        else if (weather.equals("FOG")) {
            newLng += 1;
            msg += "Where did the sky go?";
        }
        else if (weather.equals("SNOW")) {
            newHgt += 12;
            msg += "Let's go above the snow.";
        }
        this.coordinates = new Coordinates(newLng, newLat, newHgt);

        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            this.weatherTower = null;
            Simulation.log.writeLine(String.format("Helicopter#%s(%d): Setting aircraft down @ %d,%d.",
                    this.name, this.id, newLng, newLat));
            Simulation.log.writeLine(String.format("Tower says: Helicopter#%s(%d) unregistered to weather tower.",
                    this.name, this.id));
        } else {
            Simulation.log.writeLine(msg);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        Simulation.log.writeLine(String.format("Tower says: Helicopter#%s(%d) registered to weather tower.",
                this.name, this.id));
    }
}
