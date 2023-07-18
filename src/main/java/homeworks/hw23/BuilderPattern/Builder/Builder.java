package homeworks.hw23.BuilderPattern.Builder;

import homeworks.hw23.BuilderPattern.Model.Car;

public interface Builder {
    void createCar();
    void setEngine(String engine);
    void setBody(String body);
    void setSeats(int seats);
    void setGPS(boolean hasGPS);
    Car getResult();
}
