package src.main.homeworks.hw5.hw5_1to9;

public class Cat extends Member{
    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
    }

    @Override
    public String toString() {
        return "Cat " + getName();
    }
}
