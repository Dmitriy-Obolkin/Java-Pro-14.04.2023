package src.main.homeworks.hw11.hw11_2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class PetrolStation {
    private double amount;
    private final Semaphore semaphore;
    private final ReentrantLock locker;
    private final Random random;

    public PetrolStation(double amount, ReentrantLock lock){
        this.amount = amount;
        this.semaphore = new Semaphore(3); //Одновременно макс. 3 запроса
        this.random = new Random();
        this.locker = lock;
    }

    public void doRefuel(double fuel) throws InterruptedException{
        semaphore.acquire(); // получить 1 из 3 разрешение
        locker.lock();  // Блокировать только одному потоку ту часть кода, где выполняется
                        // сравнение и отнимание топлива.
        try{
            try{
                if(fuel > amount){
                    System.out.printf("(%s) Not enough fuel. Requested: %.2f, " +
                            "available: %.2f.%n", Thread.currentThread().getName(), fuel, amount);
                    return;
                }

                amount -= fuel;
                System.out.printf("(%s) Refueling started for: %.2f. Remaining fuel: %.2f.%n",
                        Thread.currentThread().getName(), fuel, amount);
            } finally {
                locker.unlock(); //Снять блокировку
            }

            Thread.sleep((random.nextInt(8) + 3) * 1000);
            System.out.printf("(%s) Refueling finished.%n",
                    Thread.currentThread().getName());

        } finally {
            semaphore.release(); //освободить 1 разрешение
        }
    }

}
