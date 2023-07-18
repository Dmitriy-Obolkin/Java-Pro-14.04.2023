package homeworks.hw23.BuilderPattern.Builder;

import homeworks.hw23.BuilderPattern.Model.Car;

public class CarBuilder implements Builder{
    private Car car;

    public CarBuilder() {
        this.createCar();
    }

    @Override
    public void createCar() {
        this.car = new Car();
    }

    @Override
    public void setEngine(String engine) {
        this.car.setEngine(engine);
    }

    @Override
    public void setBody(String body) {
        this.car.setBody(body);
    }

    @Override
    public void setSeats(int seats) {
        this.car.setSeats(seats);
    }

    @Override
    public void setGPS(boolean hasGPS) {
        this.car.setHasGPS(hasGPS);
    }

    @Override
    public Car getResult() {
        return this.car;
    }
}
