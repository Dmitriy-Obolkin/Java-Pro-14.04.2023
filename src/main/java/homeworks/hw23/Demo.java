package homeworks.hw23;

import homeworks.hw23.AbstractFactory.Factory.FurnitureFactory;
import homeworks.hw23.AbstractFactory.Factory.ModernFurnitureFactory;
import homeworks.hw23.AbstractFactory.Factory.VictorianFurnitureFactory;
import homeworks.hw23.AbstractFactory.Furniture.Chair;
import homeworks.hw23.AbstractFactory.Furniture.Closet;
import homeworks.hw23.BuilderPattern.Builder.Builder;
import homeworks.hw23.BuilderPattern.Builder.CarBuilder;
import homeworks.hw23.BuilderPattern.Builder.Director;
import homeworks.hw23.BuilderPattern.Model.Car;
import homeworks.hw23.FactoryMethod.Factory.Factory;
import homeworks.hw23.FactoryMethod.Furniture.Furniture;
import homeworks.hw23.FactoryMethod.Furniture.FurnitureType;
import homeworks.hw23.StrategyPattern.Shape.Rectangle;
import homeworks.hw23.StrategyPattern.Shape.Triangle;
import homeworks.hw23.StrategyPattern.Shape.AreaCalculator;

public class Demo {
    public static void main(String[] args) {
        Furniture chair1 = Factory.createFurniture(FurnitureType.CHAIR);
        System.out.println(chair1.getDescription());
        Furniture closet1 = Factory.createFurniture(FurnitureType.CLOSET);
        System.out.println(closet1.getDescription());


        //
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Closet victorianCloset = victorianFactory.createCloset();

        ModernFurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFurnitureFactory.createChair();
        Closet modernCloset = modernFurnitureFactory.createCloset();

        victorianChair.sit();
        modernChair.sit();
        victorianCloset.put();
        modernCloset.put();


        //
        Director director = new Director();
        Builder carBuilder = new CarBuilder();

        Car sportCar = director.constructSportCar(carBuilder);
        System.out.println(sportCar.toString());

        Car truck = director.constructTruck(carBuilder);
        System.out.println(truck.toString());


        //
        AreaCalculator areaCalculator = new AreaCalculator(new Rectangle(4, 8));
        System.out.println("Rectangle area: " + areaCalculator.calculateArea());

        areaCalculator.changeStrategy(new Triangle(4, 8));
        System.out.println("Triangle area: " + areaCalculator.calculateArea());
    }
}
