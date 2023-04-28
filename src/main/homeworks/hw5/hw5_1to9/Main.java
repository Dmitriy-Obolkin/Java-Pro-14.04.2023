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
    }
}
