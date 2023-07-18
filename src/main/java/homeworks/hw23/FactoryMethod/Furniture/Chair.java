package homeworks.hw23.FactoryMethod.Furniture;

public class Chair implements Furniture{
    private String description;

    public Chair() {
        setDescription();
    }

    @Override
    public void setDescription() {
        this.description = "This elegant and comfortable chair, made of high quality wood, will be the perfect addition to any dining table and will add charm to your interior.";
    }

    @Override
    public String getDescription() {
        return description;
    }
}
