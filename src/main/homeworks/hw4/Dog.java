package src.main.homeworks.hw4;

public class Dog extends Animal{
    /*У нашего типа животного "Dog" есть свои ограничение на бег и плавание,
     * они вынесены в static final поля, чтобы при необходимости переписать им значение,
     * не искать каждое их упоминание в классе.*/
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    /*Статическое поле dogCounter будет пренадлежать всему классу, а не его экземплярам,
     * таким образом реализуется счётчик всех созданных объектов класса Dog.*/
    private static int dogCounter = 0;
    private String name;


    public Dog(String name){
        dogCounter++; //Увеличить счётчик при каждом создании объекта класса Dog
        this.name = name;
    }


    @Override
    int getMaxRunDistance() {
        return MAX_RUN_DISTANCE;
    }
    @Override
    int getMaxSwimDistance() {
        return MAX_SWIM_DISTANCE;
    }

    public String getName() {
        return name;
    }

    /*Метод getDogCounter() статический, потому что он связан
     * со статическим полем catCounter, что позволяет получить
     * общее кол-во созданных объектов класса Dog без создания или
     * ссылки на какой-либо конкретный объект класса*/
    public static int getDogCounter() {
        return dogCounter;
    }

    @Override
    public String toString() {
        return "Dog " + getName();
    }
}
