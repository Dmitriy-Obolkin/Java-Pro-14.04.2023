package homeworks.hw23.AbstractFactory.Factory;

import homeworks.hw23.AbstractFactory.Furniture.Chair;
import homeworks.hw23.AbstractFactory.Furniture.Closet;
import homeworks.hw23.AbstractFactory.Furniture.VictorianChair;
import homeworks.hw23.AbstractFactory.Furniture.VictorianCloset;

public class VictorianFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Closet createCloset() {
        return new VictorianCloset();
    }
}
