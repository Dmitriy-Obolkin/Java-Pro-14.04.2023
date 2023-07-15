package homeworks.hw5.hw5_1to9;

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
    public boolean rest() {
        if (super.rest()){
            System.out.println(this + " went to charge. Stamina restored to maximum!");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Robot " + getName() + ", " + getPower() + "W power";
    }
}
