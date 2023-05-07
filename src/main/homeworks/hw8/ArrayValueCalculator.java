package src.main.homeworks.hw8;

public class ArrayValueCalculator {
    public int doCalc(String[][] inputArray)
            throws ArraySizeException, ArrayDataException {
        int rows = inputArray.length;
        int columns = inputArray[0].length;

        if (rows != 4 || columns != 4) {
            throw new ArraySizeException("The array must be 4x4 in size.");
        }

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    int value = Integer.parseInt(inputArray[i][j]);
                    sum += value;
                } catch (NumberFormatException e) { //Exception мотода parseInt() класса Integer
                    throw new ArrayDataException("Incorrect data in the cell [" + i + "][" + j + "].", e);
                }
            }
        }

        return sum;
    }
}
