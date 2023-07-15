package homeworks.hw2;

public class Car {






    public void start(){
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("Car has started.");
    }

    private void startElectricity() {
        System.out.println("Electricity system has started.");
    }

    private void startCommand() {
        System.out.println("Command system has started.");
    }

    private void startFuelSystem() {
        System.out.println("Fuel system has started.");
    }
}
