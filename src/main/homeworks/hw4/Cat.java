package src.main.homeworks.hw4;

public class Cat extends Animal {
    /*У нашего типа животного "Cat" есть свои ограничение на бег и плавание,
    * они вынесены в static final поля, чтобы при необходимости переписать им значение,
    * не искать каждое их упоминание в классе.*/
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0;

    /*Статическое поле catCounter будет пренадлежать всему классу, а не его экземплярам,
     * таким образом реализуется счётчик всех созданных объектов класса Cat.*/
    private static int catCounter = 0;

    private String name;


    public Cat(String name){
        catCounter++; //Увеличить счётчик при каждом создании объекта класса Cat
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

    /*Метод getCatCounter() статический, потому что он связан
     * со статическим полем catCounter, что позволяет получить
     * общее кол-во созданных объектов класса Cat без создания или
     * ссылки на какой-либо конкретный объект класса*/
    public static int getCatCounter() {
        return catCounter;
    }

    @Override
    public String toString() {
        return "Cat " + getName();
    }

}
