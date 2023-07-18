package homeworks.hw23.FactoryMethod.Furniture;

public class FurnitureTypeNotFoundException extends  RuntimeException{
    public FurnitureTypeNotFoundException(String message) {
        super(message);
    }
}
