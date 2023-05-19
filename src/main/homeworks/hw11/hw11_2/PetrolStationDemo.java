package src.main.homeworks.hw11.hw11_2;

import java.util.Random;

public class PetrolStationDemo {
    public static void main(String[] args) {
        PetrolStation station1 = new PetrolStation(500);
        Random random = new Random();

        int threadCount = random.nextInt(8) + 5; //кол-во запросов заправки

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    double fuelAmount = random.nextDouble() * 100;
                    station1.doRefuel(fuelAmount);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() +
                            " is interrupted.");
                }
            }).start();
        }

        System.out.println(threadCount);
    }
}
