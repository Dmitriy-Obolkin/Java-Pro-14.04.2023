package homeworks.hw4;

/*Для нашего условия подойдёт создание абстрактного класса,
* который определит общие свойства и методы для всех животных
* и предоставит базовый класс для наследования.*/
public abstract class Animal {

    /*Статическое поле animalCounter будет пренадлежать всему классу, а не его экземплярам-наследникам,
    * таким образом реализуется счётчик всех созданных животных.*/
    private static int animalCounter = 0;


    public Animal(){
        animalCounter++;    //Увеличить счётчик при каждом создании объекта-наследника класса Animal
    }

    /*Абстрактные методы getMaxRunDistance() и getMaxSwimDistance() обязывают наследников
    * имплиментировать у себя эти методы, это сделано для реализации условия,
    * что все животные могут бегать и плавать, и в то же время позволяет один раз написать
    * реализацию методов run() и swim(), при этом учитывая максимально возможную дистанцию
    * для каждого вида животного.*/
    abstract int getMaxRunDistance();
    abstract int getMaxSwimDistance();
    protected void run(int distance){
        //Выкинуть исключение, если переданное значение дистанции <= 0
        if(distance <= 0){
            throw new IllegalArgumentException("The distance must be a positive number!");
        }

        /*Проверить условие, может ли животное пробежать заданное растояние,
        и вывести соответствующее сообщение*/
        if(distance <= getMaxRunDistance()){
            System.out.println(this + " ran " + distance + " meters!");
        }
        else{
            System.out.println(this + " can't run " + distance + " meters!");
        }
    }
    protected void swim(int distance){
        //Выкинуть исключение, если переданное значение дистанции <= 0
        if(distance <= 0){
            throw new IllegalArgumentException("The distance must be a positive number!");
        }
        /*Проверить условие, может ли животное проплыть заданное растояние,
        и вывести соответствующее сообщение*/
        if(distance <= getMaxSwimDistance()){
            System.out.println(this + " swam " + distance + " meters!");
        }
        else{
            System.out.println(this + " can't swam " + distance + " meters!");
        }
    }

    /*Метод getAnimalCounter() статический, потому что он связан
    * со статическим полем animalCounter, что позволяет получить
    * общее кол-во созданных объектов животных без создания или
    * ссылки на какой-либо конкретный объект класса-наследника.*/
    public static int getAnimalCounter(){
        return  animalCounter;
    }
}
