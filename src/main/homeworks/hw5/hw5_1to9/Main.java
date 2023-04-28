package src.main.homeworks.hw5.hw5_1to9;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Member> members = new ArrayList<>();

        members.add(new Human("John",25,1500, 1));
        members.add(new Cat("Tom",750, 2));
        members.add(new Robot("Bot", 3500, 9000, 15));
        members.add(new Human("Kate", 21, 5000, 3));
        members.add(new Cat("Mia",300, 1));



        List<Obstacle> obstacles = new ArrayList<>();

        obstacles.add(new RunningTrack(100));
        obstacles.add(new Wall(1));
        obstacles.add(new RunningTrack(500));
        obstacles.add(new Wall(2));
        obstacles.add(new RunningTrack(1000));
        obstacles.add(new RunningTrack(2000));
        obstacles.add(new Wall(3));
        obstacles.add(new RunningTrack(5000));


        /*Сначала все учасники подходят к первому препятствию и проходят его по очереди,
        * в случае успешного прохождения - этот участник переходит к следующему препятствию*/
        List<Member> testMembers = new ArrayList<>(members);
        for (Obstacle obstacle : obstacles){
            System.out.println();
            System.out.println("Participants approach the obstacle " + obstacle + ".");
            System.out.println();
            Iterator<Member> iteratorMembers = testMembers.iterator();

            while (iteratorMembers.hasNext()) {
                Member member = iteratorMembers.next();
                System.out.println("Participant " + member + " begins to pass the obstacle " + obstacle + ".");
                if (!obstacle.overcome(member)) {
                    System.out.println("Participant " + member + " drops out of the series of obstacles!");
                    iteratorMembers.remove();
                    member.rest();
                }
                System.out.println();
            }
            System.out.println();
        }


        /*Вывести результат о прохождении испытаний*/
        Set<String> uniqueMembers = new HashSet<>();
        for (Member member : testMembers) {
            uniqueMembers.add(member.getClass().getSimpleName());
        }
        if(uniqueMembers.size() == 1 && uniqueMembers.stream().findFirst().orElse(null).equals("Robot")){
            System.out.println("The machines have won!!!");
        }
        else{
            System.out.println("List of participants who passed all the tests: ");
            int i = 1;
            for (Member member : testMembers) {
                System.out.println(i + ". " + member + "!");
                i++;
            }
        }

    }
}
