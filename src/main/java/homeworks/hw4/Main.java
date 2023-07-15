package homeworks.hw4;

public class Main {
    public static void main(String[] args) {
        Cat catBarsik = new Cat("Barsik");
        catBarsik.swim(25);
        catBarsik.run(100);
        Cat catTom = new Cat("Tom");
        catTom.run(1000);
        System.out.println("Objects of the Animal class have been created: " + Animal.getAnimalCounter());
        System.out.println("Objects of the Cat class have been created: " + Cat.getCatCounter());
        System.out.println("Objects of the Dog class have been created: " + Dog.getDogCounter());

        System.out.println();

        Dog dogSharik = new Dog("Sharik");
        dogSharik.run(450);
        dogSharik.swim(8);
        dogSharik.swim(15);
        System.out.println("Objects of the Animal class have been created: " + Animal.getAnimalCounter());
        System.out.println("Objects of the Cat class have been created: " + Cat.getCatCounter());
        System.out.println("Objects of the Dog class have been created: " + Dog.getDogCounter());
    }
}
