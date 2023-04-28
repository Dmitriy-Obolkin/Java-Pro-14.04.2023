package src.main.homeworks.hw5.hw5_1to9;

public class Robot extends Member{
    public int power;

    public Robot(String name, int power, int maxRunDistance, int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void rest() {
        super.rest();
        System.out.println(this + " went to charge. Stamina restored to maximum!");
    }

    @Override
    public String toString() {
        return "Robot " + getName() + ", " + getPower() + "W power";
    }
}
