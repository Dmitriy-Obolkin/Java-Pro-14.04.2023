package src.main.homeworks.hw17;

import src.main.homeworks.hw15.Student;

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





    }
}
