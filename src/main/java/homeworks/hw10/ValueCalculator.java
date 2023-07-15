package homeworks.hw10;

import java.util.Arrays;

public class ValueCalculator {
    float[] numbersArray;
    int arraySize;

    int halfSize;

    public ValueCalculator(int arraySize){
        setArraySize(arraySize);
    }

    public int getArraySize() {
        return arraySize;
    }

    private void setArraySize(int arraySize) {
        if(arraySize >= 1_000_000){
            this.arraySize = arraySize;
            this.numbersArray = new float[arraySize];
            setHalfSize(arraySize);
        }else {
         throw new IllegalArgumentException("The minimum size of the array must be >= 1000000");
        }
    }

    public int getHalfSize() {
        return halfSize;
    }

    private void setHalfSize(int halfSize) {
        this.halfSize = halfSize/2;
    }

    public void calculate(){
        long start = System.currentTimeMillis();

        Arrays.fill(numbersArray, 16);
        float[] a1 = new float[halfSize];
        float[] a2 = (arraySize%2) == 0 ? new float[halfSize] : new float[halfSize+1];

        System.arraycopy(numbersArray, 0, a1, 0, halfSize);
        System.arraycopy(numbersArray, halfSize, a2, 0, (numbersArray.length - halfSize));

        Thread t1 = new Thread(() -> calculateValues(a1, 0));
        Thread t2 = new Thread(() -> calculateValues(a2, halfSize));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.arraycopy(a1, 0, numbersArray, 0, halfSize);
        System.arraycopy(a2, 0, numbersArray, halfSize, (numbersArray.length - halfSize));

        System.out.println("Runtime: " + (System.currentTimeMillis() - start) + "ms");
    }

    private void calculateValues(float[] array, int offset) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (double) (i + offset) / 5) *
                    Math.cos(0.2f + (double) (i + offset) / 5) * Math.cos(0.4f + (double) (i + offset) / 2));
        }
    }
}
