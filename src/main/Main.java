package src.main;

import src.main.homeworks.hw2.Car;
import src.main.homeworks.hw2.Employee;

public class Main {
    public static void main(String[] args){

        demoHW2();
    }


    private static void demoHW2(){
        Employee tom = new Employee("Tom Franklin", "director", "tom-franklin@gmail.com", "4627-3756", 29);
        System.out.println(tom);

        System.out.println();

        Car teslaCar = new Car();
        teslaCar.start();;
    }
}
