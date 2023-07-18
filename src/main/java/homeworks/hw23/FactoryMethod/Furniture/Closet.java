package homeworks.hw23.FactoryMethod.Furniture;

public class Closet implements Furniture{
    private String description;

    public Closet() {
        setDescription();
    }

    @Override
    public void setDescription() {
        this.description = "The spacious and stylish closet, equipped with convenient shelves and drawers, is ideal for storing clothes and accessories, keeping your bedroom tidy.";
    }

    @Override
    public String getDescription() {
        return description;
    }
}
