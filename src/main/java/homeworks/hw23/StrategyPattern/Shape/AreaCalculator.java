package homeworks.hw23.StrategyPattern.Shape;

import homeworks.hw23.StrategyPattern.Strategy.AreaCalculationStrategy;

public class AreaCalculator {
    private AreaCalculationStrategy strategy;

    public AreaCalculator(AreaCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(AreaCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateArea() {
        return strategy.calculateArea();
    }
}
