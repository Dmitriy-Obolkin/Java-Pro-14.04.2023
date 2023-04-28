package src.main.homeworks.hw5.hw5_1to9;

public class Human extends Member implements Rest{
    public int age;

    public Human(String name, int age, int maxRunDistance, int maxJumpHeight){
        super(name, maxRunDistance, maxJumpHeight);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void rest() {
        //отдыхать
    }

    @Override
    public String toString() {
        return "Human " + getName() + ", " + getAge() + "years old";
    }
}
