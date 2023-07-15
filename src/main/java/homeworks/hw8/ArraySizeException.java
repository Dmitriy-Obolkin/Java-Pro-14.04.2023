package homeworks.hw8;

/*Создание ArraySizeException с конструктором с параметром String message,
* который позволит на объектах ArraySizeException вызывать метод
* класса-родителя Throwable - getMessage()*/
public class ArraySizeException extends Exception{
    public ArraySizeException(String message) {
        super(message);
    }
}
