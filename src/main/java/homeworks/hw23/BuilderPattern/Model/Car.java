package homeworks.hw23.BuilderPattern.Model;

public class Car {
    private String engine;
    private String body;
    private int seats;
    private boolean hasGPS;

    // getters and setters
    public void setEngine(String engine) { this.engine = engine; }
    public void setBody(String body) { this.body = body; }
    public void setSeats(int seats) { this.seats = seats; }
    public void setHasGPS(boolean hasGPS) { this.hasGPS = hasGPS; }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", body='" + body + '\'' +
                ", seats=" + seats +
                ", hasGPS=" + hasGPS +
                '}';
    }
}
