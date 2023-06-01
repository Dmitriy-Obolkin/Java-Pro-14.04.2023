package src.main.homeworks.hw15;

public class MyShakerSort {

    // region ShakerSort int
    public static void shakerSortIntArray(int[] arr){
        if(arr.length < 2){
            throw new IllegalArgumentException("Incorrect array");
        }

        int left = 1;
        int right = arr.length-1;
        boolean swapped = true;

        while(swapped){

            //Обход массива слева направо, если текущий элемент меньше предыдущего, то поменять их местами
            for (int i = left; i <= right ; i++) {
                if(arr[i] < arr[i-1]){
                    swapInt(arr, i);
                    swapped = true;
                }
            }
            right--;

            //Если за проход массива не было ни одной перестановки - закончить цикл (аналогично в while(swapped))
            if(!swapped)
                break;

            swapped = false;

            //Обход массива справа налево, если текущий элемент меньше предыдущего, то поменять их местами
            for (int i = right; i >= left; i--) {
                if(arr[i] < arr[i-1]){
                    swapInt(arr, i);
                    swapped = true;
                }
            }
            left++;
        }
    }
    private static void swapInt(int[] arr, int idx){
        int tmp = arr[idx];
        arr[idx] = arr[idx-1];
        arr[idx-1] = tmp;
    }
    // endregion ShakerSort int


    // region ShakerSort generics
    public static <T extends Comparable<T>> void shakerSort(T ... arr){
        if(arr.length < 2 ){
            throw new IllegalArgumentException("Incorrect array");
        }

        int left = 1;
        int right = arr.length-1;
        boolean swapped = true;

        while(swapped){

            //Обход массива слева направо, если текущий элемент меньше предыдущего, то поменять их местами
            for (int i = left; i <= right ; i++) {
                int cmp = arr[i].compareTo(arr[i-1]);
                if(cmp < 0){
                    swap(i, arr);
                    swapped = true;
                }
            }
            right--;

            //Если за проход массива не было ни одной перестановки - закончить цикл (аналогично в while(swapped))
            if(!swapped)
                break;

            swapped = false;

            //Обход массива справа налево, если текущий элемент меньше предыдущего, то поменять их местами
            for (int i = right; i >= left; i--) {
                int cmp = arr[i].compareTo(arr[i-1]);
                if(cmp < 0){
                    swap(i, arr);
                    swapped = true;
                }
            }
            left++;
        }
    }
    private static <T> void swap(int idx, T ... arr){
        T tmp = arr[idx];
        arr[idx] = arr[idx-1];
        arr[idx-1] = tmp;
    }
    // endregion ShakerSort generics
}
