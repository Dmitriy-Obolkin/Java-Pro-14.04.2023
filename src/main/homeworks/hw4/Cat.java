package src.main.homeworks.hw4;

public class Cat extends Animal {
    /*У нашего типа животного "кот" есть свои ограничение на бег и плавание,
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


    public String getName() {
        return name;
    }

    /*Обязательное переопределение методов run() и swim() из базового класса,
    * но с собственными ограничениями класса Cat*/
    @Override
    public void run(int distance) {
        //Выкинуть исключение, если переданное значение дистанции <= 0
        if(distance <= 0){
            throw new IllegalArgumentException("The distance must be a positive number!");
        }

        /*Проверить условие, может ли кот пробежать заданное растояние,
        и вывести соответствующее сообщение*/
        if(distance <= MAX_RUN_DISTANCE){
            System.out.println(this + " ran " + distance + " meters!");
        }
        else{
            System.out.println(this + " can\'t run " + distance + " meters!");
        }
    }

    @Override
    public void swim(int distance) {
        //Выкинуть исключение, если переданное значение дистанции <= 0
        if(distance <= 0){
            throw new IllegalArgumentException("The distance must be a positive number!");
        }

        /*Проверить условие, может ли кот проплыть заданное растояние,
        и вывести соответствующее сообщение*/
        if(distance <= MAX_SWIM_DISTANCE){
            System.out.println(this + " swam " + distance + " meters!");
        }
        else{
            System.out.println(this + " can\'t swam " + distance + " meters!");
        }
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
