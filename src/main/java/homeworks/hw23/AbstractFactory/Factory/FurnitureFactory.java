package homeworks.hw23.AbstractFactory.Factory;

import homeworks.hw23.AbstractFactory.Furniture.Chair;
import homeworks.hw23.AbstractFactory.Furniture.Closet;

public interface FurnitureFactory {
    Chair createChair();
    Closet createCloset();
}
