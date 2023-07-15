package homeworks.hw5.hw5_0;

//Класс Квадрат, который реализует интерфейс Shape
public class Square implements Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }
}
