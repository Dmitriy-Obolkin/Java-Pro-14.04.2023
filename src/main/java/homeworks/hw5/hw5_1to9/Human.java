package homeworks.hw5.hw5_1to9;

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
    public boolean rest() {
        if (super.rest()){
            System.out.println(this + " went to watch TV. Stamina restored to maximum!");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Human " + getName() + ", " + getAge() + " years old ";
    }
}
