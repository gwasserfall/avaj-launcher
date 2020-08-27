package avaj.aircraft;

import avaj.interfaces.Flyable;
import avaj.weather.WeatherTower;

abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    public Aircraft(String name, Coordinates coordinates) {
        this.id = idCounter;
        this.name = name;
        this.coordinates = coordinates;
        nextId();
    }

    private void nextId() {
        idCounter++;
    }
}