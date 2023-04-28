package src.main.homeworks.hw5.hw5_1to9;

public class Human extends Member{
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
        super.rest();
        System.out.println(this + " went to watch TV. Stamina restored to maximum!");
    }

    @Override
    public String toString() {
        return "Human " + getName() + ", " + getAge() + " years old ";
    }
}
