package src.main.homeworks.hw5.hw5_1to9;

public abstract class Member {


    protected int maxRunDistance;
    protected int maxJumpHeight;
    public String name;

    public Member(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }
    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }
    public String getName() {
        return name;
    }

    private void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }
    private void setMaxJumpHeight(int maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run(int distance){
        if(distance <= 0){
            throw new IllegalArgumentException("The distance must be a positive number!");
        }

        if(distance <= getMaxRunDistance()){
            System.out.println(this + " runs for a distance of: " + distance + " meters");
        }
        else {
            System.out.println(this + " cannot run a distance of: " + distance + " meters");
        }
    }
    public void jump(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("The height must be a positive number!");
        }

        if (height <= getMaxJumpHeight()) {
            System.out.println(this + " jumps to a height of: " + height + " meters");
        } else {
            System.out.println(this + " cannot jumps to a height of: " + height + " meters");
        }
    }

}
