package avaj.aircraft;

import avaj.interfaces.Flyable;
import avaj.simulation.Simulation;
import avaj.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) { super(name, coordinates); }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String msg = String.format("Baloon#%s(%d): ", this.name, this.id);
        int newLng = this.coordinates.getLongitude();
        int newLat = this.coordinates.getLatitude();
        int newHgt = this.coordinates.getHeight();

        if (weather.equals("SUN")) {
            newLng += 10;
            newHgt += 4;
            msg += "Time to ride the sunshine.";
        }
        else if (weather.equals("RAIN")) {
            newHgt -= 5;
            msg += "It's too wet here, going down!";
        }
        else if (weather.equals("FOG")) {
            newHgt -= 3;
            msg += "Can't see anything.. Descend descend!";
        }
        else if (weather.equals("SNOW")) {
            newHgt -= 15;
            msg += "Wow I've never seen snow before.";
        }
        this.coordinates = new Coordinates(newLng, newLat, newHgt);

        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            Simulation.log.writeLine(String.format("Baloon#%s(%d): Setting aircraft down @ %d,%d.",
                    this.name, this.id, newLng, newLat));
            Simulation.log.writeLine(String.format("Tower says: Baloon#%s(%d) registered to weather tower.",
                    this.name, this.id));
        } else {
            Simulation.log.writeLine(msg);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        Simulation.log.writeLine(String.format("Tower says: Baloon#%s(%d) unregistered to weather tower.",
                this.name, this.id));
    }
}
