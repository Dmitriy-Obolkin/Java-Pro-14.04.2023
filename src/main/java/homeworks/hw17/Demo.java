package homeworks.hw17;

import homeworks.hw15.Student;
import homeworks.hw17.FruitBoxes.Apple;
import homeworks.hw17.FruitBoxes.Box;
import homeworks.hw17.FruitBoxes.Orange;

import java.util.List;

public class Demo {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = MyCollectionUtils.toList(intArray);

        System.out.println("Integers list: " + intList);


        Student anna = new Student("Anna", 22);
        Student petro = new Student("Petro", 35);
        Student ivan = new Student("Ivan", 48);
        Student vasyl = new Student("Vasyl", 21);
        Student olha = new Student("Olha", 31);
        Student maxim = new Student("Maxim", 37);
        Student[] studentsArray = {anna, petro, ivan, vasyl, olha, maxim};

        List<Student> studentsList = MyCollectionUtils.toList(studentsArray);

        System.out.println("Students list: " + studentsList);
        System.out.println();



        //FRUIT:

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple(), 6);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(), 4);

        System.out.println("Weight of appleBox: " + appleBox.getWeight());
        System.out.println("Weight of orangeBox: " + orangeBox.getWeight());


        System.out.println("appleBox weight equal to orangeBox weight: " + appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple(), 6);
        System.out.println("Weight of appleBox2: " + appleBox2.getWeight());
        System.out.println("orangeBox weight equal to appleBox2 weight: " + orangeBox.compare(appleBox2));


        System.out.println("\nMerging appleBox2 with a appleBox:");
        appleBox.merge(appleBox2);
        System.out.println("Weight of appleBox: " + appleBox.getWeight());
        System.out.println("Weight of appleBox2: " + appleBox2.getWeight());

    }
}
