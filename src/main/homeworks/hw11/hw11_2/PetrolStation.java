package src.main.homeworks.hw11.hw11_2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStation {
    private double amount;
    private Semaphore semaphore;
    private Random random;

    public PetrolStation(double amount){
        this.amount = amount;
        this.semaphore = new Semaphore(3); //Одновременно макс. 3 запроса
        this.random = new Random();
    }

    public void doRefuel(double fuel) throws InterruptedException{
        semaphore.acquire(); // получить 1 из 3 разрешение
        try{
            if(fuel > amount){
                System.out.println(String.format("(%s) Not enough fuel. Requested: %.2f, " +
                        "available: %.2f.", Thread.currentThread().getName(), fuel, amount));
                return;
            }

            System.out.println(String.format("(%s) Refueling started for: %.2f.",
                    Thread.currentThread().getName(), fuel));
            amount -= fuel;
            Thread.sleep((random.nextInt(8) + 3) * 1000);
            System.out.println(String.format("(%s) Refueling finished. Remaining fuel: %.2f.",
                    Thread.currentThread().getName(), amount));

        } finally {
            semaphore.release(); //освободить 1 разрешение
        }
    }

}
