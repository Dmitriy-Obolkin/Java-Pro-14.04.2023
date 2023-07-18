package homeworks.hw23.StrategyPattern.Shape;

import homeworks.hw23.StrategyPattern.Strategy.AreaCalculationStrategy;

public class Triangle implements AreaCalculationStrategy {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
