package src.main.homeworks.hw5.hw5_1to9;

public class RunningTrack implements Obstacle{
    private final int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean overcome(Member member) {
        if (member.run(getLength())) {
            System.out.println("+" + member + " successfully overcame the obstacle of the " + this + "!");
            return true;
        } else {
            System.out.println("-" + member + " could not overcome the obstacle of the " + this + "!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "RunningTrack with a length of " + getLength() + " meters";
    }
}
