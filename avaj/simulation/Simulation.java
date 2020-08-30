package avaj.simulation;

import avaj.exceptions.*;
import avaj.interfaces.Flyable;
import avaj.aircraft.AircraftFactory;
import avaj.visualise.Visualise;
import avaj.weather.WeatherTower;

import java.io.IOException;

public class Simulation {
    private static WeatherTower weatherTower = new WeatherTower();
    public static Visualise visualise = new Visualise();
    public static Logger log = new Logger("simulation.txt");

    public static void main(String[] args) {

        try {
            Validate validate = new Validate(args);

            for (Scenario s : validate.getScenario()) {
                Flyable aircraft = AircraftFactory.newAircraft(s.type, s.name, s.longitude, s.latitude, s.height);
                visualise.drawInitialAircraft(s.longitude, s.latitude, s.height);
                aircraft.registerTower(weatherTower);
            }

            for (int i = 0; i < validate.iterations; i++) {
                weatherTower.changeWeather();
            }

            visualise.saveImage();
        }
        catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Could not do bonus");
        }
        finally {
            log.closeLogger();
        }
    }


}
