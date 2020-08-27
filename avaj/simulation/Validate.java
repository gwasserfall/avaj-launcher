package avaj.simulation;

import avaj.exceptions.*;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Validate {
    private final ArrayList<String> scenario = new ArrayList<String>();
    private final ArrayList<Scenario> scenariosValidated = new ArrayList<Scenario>();
    private final List<String> validAircraft = Arrays.asList("Baloon", "JetPlane", "Helicopter");
    public int iterations;

    public Validate (String[] args) throws ValidationException {

        if (args.length != 1) {
            throw new ValidationException("Please specify a simulation file path. No other arguments are required");
        }

        try {
            Scanner inFile = new Scanner(new File(args[0]));

            while(inFile.hasNext()) {
                this.scenario.add(inFile.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            throw new ValidationException(String.format("%s cannot be found.", args[0]));
        }

        validateScenario();
        validateIterations();
        validateAircraft();
    }

    private void validateScenario() throws ValidationException {
        if (scenario.size() <= 2) {
            throw new ValidationException("Incorrect format in scenario file.");
        }
    }

    private void validateIterations() throws ValidationException {
        try {
            this.iterations = Integer.parseInt(scenario.remove(0));
        } catch (NumberFormatException e) {
            throw new ValidationException("Iterations is not an integer.");
        }

        if (this.iterations <= 0) {
            throw new ValidationException("Iterations must be positive.");
        }
    }

    private void validateAircraft()  throws ValidationException {
        for (String line: scenario) {
            String[] i = line.split(" ");

            if (i.length != 5) {
                throw new ValidationException("Syntax error in scenario file.");
            }

            try {
                Integer.parseInt(i[2]);
                Integer.parseInt(i[3]);
                Integer.parseInt(i[4]);
            } catch (NumberFormatException e) {
                throw new ValidationException("Syntax error in coordinates in line [" + line + "]");
            }

            if (i[0].length() < 1) {
                throw new ValidationException("Aircraft type cannot be empty.");
            }

            if (i[1].length() < 1) {
                throw new ValidationException("Aircraft name cannot be empty.");
            }

            if (!validAircraft.contains(i[0])) {
                throw new ValidationException(String.format("%s is not a valid Aircraft type.", i[0]));
            }

            scenariosValidated.add(new Scenario(i[0], i[1], i[2], i[3], i[4]));
        }
    }

    public ArrayList<Scenario> getScenario() {
        return scenariosValidated;
    }
}
