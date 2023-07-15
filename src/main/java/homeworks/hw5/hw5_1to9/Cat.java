package homeworks.hw5.hw5_1to9;

public class Cat extends Member{
    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
    }

    @Override
    public String toString() {
        return "Cat " + getName();
    }

    @Override
    public boolean rest() {
        if (super.rest()){
            System.out.println(this + " went to bed. Stamina restored to maximum!");
            return true;
        }
        return false;
    }
}
