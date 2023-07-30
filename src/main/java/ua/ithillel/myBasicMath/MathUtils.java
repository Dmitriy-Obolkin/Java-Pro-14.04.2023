package ua.ithillel.myBasicMath;

public class MathUtils {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static double sin(double number) {
        return Math.sin(number);
    }

    public static double cos(double number) {
        return Math.cos(number);
    }

    public static double tan(double number) {
        return Math.tan(number);
    }

    public static double cot(double number) {
        double tan = Math.tan(number);
        if (tan == 0) {
            throw new ArithmeticException("Cotangent of pi/2");
        }
        return 1.0 / tan;
    }

    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    public static double abs(double number) {
        return Math.abs(number);
    }
}
