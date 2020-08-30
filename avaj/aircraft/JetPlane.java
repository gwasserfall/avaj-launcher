package avaj.aircraft;

import avaj.interfaces.Flyable;
import avaj.simulation.Simulation;
import avaj.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        String msg = String.format("JetPlane#%s(%d): ", this.name, this.id);
        int newLng = this.coordinates.getLongitude();
        int newLat = this.coordinates.getLatitude();
        int newHgt = this.coordinates.getHeight();

        if (weather.equals("SUN")) {
            newLat += 10;
            newHgt += 2;
            msg += "Higher for more sun!.";
        }
        else if (weather.equals("RAIN")) {
            newLat += 5;
            msg += "Wow rain here? Take us higher captain.";
        }
        else if (weather.equals("FOG")) {
            newLat += 1;
            msg += "Can't see anything.. Maybe up a little.";
        }
        else if (weather.equals("SNOW")) {
            newHgt -= 7;
            msg += "It doesn't even snow in this country?";
        }
        this.coordinates = new Coordinates(newLng, newLat, newHgt);

        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            Simulation.log.writeLine(String.format("JetPlane#%s(%d): Setting aircraft down @ %d,%d.", this.name,
                    this.id, newLng, newLat));
            Simulation.log.writeLine(String.format("Tower says: JetPlane#%s(%d) unregistered to weather tower.",
                    this.name, this.id));
        } else {
            Simulation.log.writeLine(msg);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        Simulation.log.writeLine(String.format("Tower says: JetPlane#%s(%d) registered to weather tower.",
                this.name, this.id));
    }
}
