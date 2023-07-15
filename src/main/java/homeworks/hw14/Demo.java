package homeworks.hw14;

import homeworks.hw14.coffee.order.CoffeeOrderBoard;

public class Demo {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("Tom");
        coffeeOrderBoard.add("John");
        coffeeOrderBoard.add("Alice");
        coffeeOrderBoard.add("Leo");

        System.out.println();
        coffeeOrderBoard.draw();

        System.out.println();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(3);
        coffeeOrderBoard.deliver(10);


        System.out.println();
        coffeeOrderBoard.draw();
    }
}
