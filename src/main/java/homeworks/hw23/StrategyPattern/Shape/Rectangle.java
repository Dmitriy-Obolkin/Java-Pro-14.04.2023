package homeworks.hw23.StrategyPattern.Shape;

import homeworks.hw23.StrategyPattern.Strategy.AreaCalculationStrategy;

public class Rectangle implements AreaCalculationStrategy {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
