package homeworks.hw23.FactoryMethod.Factory;

import homeworks.hw23.FactoryMethod.Furniture.*;

public abstract class Factory {
    public static Furniture createFurniture(FurnitureType type){
        if(type == FurnitureType.CHAIR){
            return new Chair();
        } else if (type == FurnitureType.CLOSET){
            return new Closet();
        }
        throw new FurnitureTypeNotFoundException("Furniture type " + type + " not found");
    }
}
