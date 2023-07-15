package homeworks.hw5.hw5_1to9;

public class Wall implements Obstacle{
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean overcome(Member member) {
        if (member.jump(getHeight())) {
            System.out.println("+" + member + " successfully overcame the obstacle of the " + this + "!");
            return true;
        } else {
            System.out.println("-" + member + " could not overcome the obstacle of the " + this + "!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "the wall is " + getHeight() + " meters high ";
    }
}
