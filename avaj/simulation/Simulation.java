package avaj.simulation;

import avaj.exceptions.*;
import avaj.interfaces.Flyable;
import avaj.aircraft.AircraftFactory;
import avaj.weather.WeatherTower;

public class Simulation {
    private static WeatherTower weatherTower = new WeatherTower();

    public static void main(String[] args) throws Exception {
        try {
            Validate validate = new Validate(args);

            for (Scenario s : validate.getScenario()) {
                Flyable aircraft = AircraftFactory.newAircraft(s.type, s.name, s.longitude, s.latitude, s.height);
                aircraft.registerTower(weatherTower);
            }

            for (int i = 0; i < validate.iterations; i++) {
                weatherTower.changeWeather();
            }
        }
        catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
