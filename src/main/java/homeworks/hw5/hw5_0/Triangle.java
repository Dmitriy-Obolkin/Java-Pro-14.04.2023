package homeworks.hw5.hw5_0;

//Класс Треугольник, который реализует интерфейс Shape
public class Triangle implements Shape{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
