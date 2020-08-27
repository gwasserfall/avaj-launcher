package avaj.simulation;

public class Scenario {
    public String type;
    public String name;
    public Integer longitude;
    public Integer latitude;
    public Integer height;

    public Scenario(String type, String name, String longitude, String latitude, String height) {
        this.type = type;
        this.name = name;
        this.longitude = Integer.parseInt(longitude);
        this.latitude = Integer.parseInt(latitude);
        this.height = Integer.parseInt(height);
    }
}
