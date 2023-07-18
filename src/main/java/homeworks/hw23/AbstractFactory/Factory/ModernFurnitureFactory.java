package homeworks.hw23.AbstractFactory.Factory;

import homeworks.hw23.AbstractFactory.Furniture.Chair;
import homeworks.hw23.AbstractFactory.Furniture.Closet;
import homeworks.hw23.AbstractFactory.Furniture.ModernChair;
import homeworks.hw23.AbstractFactory.Furniture.ModernCloset;

public class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Closet createCloset() {
        return new ModernCloset();
    }
}
