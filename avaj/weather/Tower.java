package avaj.weather;

import java.util.ArrayList;
import java.util.Collections;

import avaj.interfaces.Flyable;

public class Tower {
    private static ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable aircraft) {
        if (!observers.contains(aircraft)) {
            observers.add(aircraft);
        }
    }

    public void unregister(Flyable aircraft) {
        observers.remove(aircraft);
    }

    protected void conditionsChanged() {
        ArrayList<Flyable> obsCopy = new ArrayList<Flyable>(observers);
        Collections.reverse(obsCopy);
        for (int i = obsCopy.size() - 1; i >= 0; i--) {
            obsCopy.get(i).updateConditions();
        }
    }
}
