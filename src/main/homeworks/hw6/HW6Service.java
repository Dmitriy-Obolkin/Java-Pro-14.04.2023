package src.main.homeworks.hw6;
import java.time.Year;

public class HW6Service {
    //2
    public static void printThreeWords(){
        System.out.println("\n2:");

        System.out.println("Orange\nBanana\nApple");
    }

    //3
    public static void checkSumSign(){
        System.out.println("\n3:");

        int a = 87;
        int b = 137;

        System.out.println((a+b) >= 0 ? "Сума позитивна" : "Сума негативна");
    }

    //4
    public static void printColor(){
        System.out.println("\n4:");

        int value = -153;

        if(value <= 0){
            System.out.println("Червоний");
        } else if(value > 0 && value <= 100){
            System.out.println("Жовтий");
        } else{
            System.out.println("Зелений");
        }
    }

    //5
    public static void compareNumbers(){
        System.out.println("\n5:");

        int a = 12;
        int b = 109;

        System.out.println( (a >= b) ? "a >= b" : "a < b");
    }

    //6
    public static boolean isSumInRange(int a, int b){
        System.out.println("\n6:");

        return ((a+b) >= 10 && (a+b) <= 20) ? true : false;
    }

    //7
    public static void checkPositiveOrNegative(int num){
        System.out.println("\n7:");

        System.out.println((num>=0) ? "Число " + num + " додатне" : "Число " + num + " від’ємне");
    }

    //8
    public static boolean isNegative(int num){
        System.out.println("\n8:");

        return (num < 0) ? true : false;
    }

    //9
    public static void printStringMultipleTimes(String str, int times){
        System.out.println("\n9:");

        for(int i = 0; i < times; i++){
            System.out.println(str);
        }
    }

    //10
    public static boolean isLeapYear(int year){
        System.out.println("\n10:");

        if((year%400) == 0){ //*...кожен 400-й – високосний...*
            return true;
        } else if ((year%100) == 0) {//*...крім кожного 100-го...*
            return false;
        } else if((year%4) == 0){//*...кожен 4-й рік є високосним...*
            return true;
        } else {
            return false;
        }
    }

    //10_2
    public static boolean isLeapYear2(int year){
        return Year.of(year).isLeap();
    }
}
