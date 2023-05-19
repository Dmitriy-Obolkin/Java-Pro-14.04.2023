package src.main.homeworks.hw11.hw11_2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStation {
    private double amount;
    private final Semaphore semaphore;
    private final Random random;

    public PetrolStation(double amount){
        this.amount = amount;
        this.semaphore = new Semaphore(3); //Одновременно макс. 3 запроса
        this.random = new Random();
    }

    public void doRefuel(double fuel) throws InterruptedException{
        semaphore.acquire(); // получить 1 из 3 разрешение
        try{
            if(fuel > amount){
                System.out.printf("(%s) Not enough fuel. Requested: %.2f, " +
                        "available: %.2f.%n", Thread.currentThread().getName(), fuel, amount);
                return;
            }

            System.out.printf("(%s) Refueling started for: %.2f.%n",
                    Thread.currentThread().getName(), fuel);
            amount -= fuel;
            Thread.sleep((random.nextInt(8) + 3) * 1000);
            System.out.printf("(%s) Refueling finished. Remaining fuel: %.2f.%n",
                    Thread.currentThread().getName(), amount);

        } finally {
            semaphore.release(); //освободить 1 разрешение
        }
    }

}
