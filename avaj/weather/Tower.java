package avaj.weather;

import java.util.ArrayList;
import avaj.interfaces.Flyable;

public class Tower {
    private static ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable aircraft) { observers.add(aircraft); }

    public void unregister(Flyable aircraft) {
        observers.remove(aircraft);
    }

    protected void conditionsChanged() {
        for (Flyable aircraft : observers) {
            //aircraft.changeWeather();
        }
    }
}
