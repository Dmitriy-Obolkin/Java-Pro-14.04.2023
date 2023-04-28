package src.main.homeworks.hw5.hw5_1to9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();

        members.add(new Human("John",25,1500, 1));
        members.add(new Cat("Tom",750, 2));
        members.add(new Robot("Bot", 3500, 9000, 15));
        members.add(new Human("Kate", 21, 5000, 3));
        members.add(new Cat("Mia",300, 1));

        /*for (Member member : members) {
            System.out.println("Stamina: " + member.getStamina());
            member.run(800);
            System.out.println("Stamina: " + member.getStamina());
            member.jump(2);
            System.out.println();
        }*/

        List<Obstacle> obstacles = new ArrayList<>();

        obstacles.add(new RunningTrack(100));
        //obstacles.add(new Wall(1));
        obstacles.add(new RunningTrack(500));
        //obstacles.add(new Wall(2));
        obstacles.add(new RunningTrack(1000));
        //obstacles.add(new Wall(3));


        for (Obstacle obstacle : obstacles){
            System.out.println("Participants approach the obstacle " + obstacle);
        }

    }
}
