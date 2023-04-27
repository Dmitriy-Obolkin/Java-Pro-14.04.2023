package src.main.homeworks.hw5.hw5_0;

import java.util.List;

public class ShapeService {
    public static double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}
