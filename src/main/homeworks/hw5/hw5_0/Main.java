package src.main.homeworks.hw5.hw5_0;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(5.0));
        shapes.add(new Triangle(4.0, 6.0));
        shapes.add(new Square(3.0));
        shapes.add(new Circle(2.5));
        shapes.add(new Triangle(3.0, 5.0));
        shapes.add(new Square(4.5));
        shapes.add(new Circle(1.5));
        shapes.add(new Triangle(2.0, 4.0));

        double totalArea = ShapeService.calculateTotalArea(shapes);
        System.out.println("The total area of all shapes: " + totalArea);
    }
}
