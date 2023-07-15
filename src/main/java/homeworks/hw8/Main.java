package homeworks.hw8;

public class Main {
    public static void main(String[] args) {
        String[][] inputArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "аа", "15", "16"},
        };

        ArrayValueCalculator calculator = new ArrayValueCalculator();

        try {
            int result = calculator.doCalc(inputArray);
            System.out.println("Calculation result: " + result);
        } catch (ArraySizeException e) {
            System.err.println("Array size error: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println("Array data error: " + e.getMessage());
        }
    }
}
