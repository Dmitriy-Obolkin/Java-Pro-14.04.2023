package homeworks.hw23.BuilderPattern.Builder;

import homeworks.hw23.BuilderPattern.Model.Car;

public class Director {
    public Car constructSportCar(Builder builder) {
        builder.createCar();
        builder.setEngine("Sport engine");
        builder.setBody("Sport body");
        builder.setSeats(2);
        builder.setGPS(false);

        return builder.getResult();
    }

    public Car constructTruck(Builder builder) {
        builder.createCar();
        builder.setEngine("Truck engine");
        builder.setBody("Truck body");
        builder.setSeats(2);
        builder.setGPS(true);

        return builder.getResult();
    }
}
