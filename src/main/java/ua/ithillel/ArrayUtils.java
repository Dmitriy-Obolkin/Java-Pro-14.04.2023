package main.java.ua.ithillel;

public class ArrayUtils {

    public static int[] getElementsAfterLastFour(int[] arr) {
        int lastFourIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFourIndex = i;
            }
        }

        if (lastFourIndex == -1) {
            throw new RuntimeException("The array must contain at least one '4'.");
        }

        int[] result = new int[arr.length - lastFourIndex - 1];
        System.arraycopy(arr, lastFourIndex + 1, result, 0, result.length);

        return result;
    }

    public static boolean containsOneAndFour(int[] arr) {
        boolean hasOne = false;
        boolean hasFour = false;

        for (int num : arr) {
            if (num == 1) {
                hasOne = true;
            }
            if (num == 4) {
                hasFour = true;
            }
        }

        return hasOne && hasFour;
    }
}
