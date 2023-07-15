package homeworks.hw15;

import java.util.Comparator;

public class MyQuickSort {

    // region  QuickSort int
    public static void quickSortIntArray(int[] arr, int left, int right){
        if(left < right){
            int pivotIdx = partitionInt(arr, left, right);

            //Рекурсивный вызов сортировки для каждой части массива относительно индекса разделения
            quickSortIntArray(arr, left, pivotIdx);
            quickSortIntArray(arr, pivotIdx + 1, right);
        }
    }

    private static int partitionInt(int[] arr, int left, int right){
        //int pivot = arr[(left + right) / 2]; //Один из способов вычисления опорного элемента
        //int pivot = (arr[left] + arr[right]) / 2; //Один из способов вычисления опорного элемента
        int pivot = medianOfThreeInt(arr, left, right); //Вычисление опорного элемента как медианы трёх

        while (left <= right){ //Пока левый и правый индексы не пересекутся:
            while(arr[left] < pivot){ //Обходить левую часть, пока её элементы меньше опорного
                left++;
            }
            while (arr[right] > pivot){ //Обходить правую часть, пока её элементы больше опорного
                right--;
            }

            //Если левый и правый индексы пересеклись - выйти
            if(left >= right){
                break;
            }

            //Иначе - поменять местами элемент, который больше опорного и стоит слева от него,
            //с элементом, который меньше опорного и стоит справа
            swapInt(arr, left++, right--);
        }

        //Вернуть индекс элемента, относительно которого сейчас отсортирован массив
        return right;
    }

    private static void swapInt(int[] arr, int leftIdx, int rightIdx){
        int tmp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = tmp;
    }

    //Вычисление среднего из значений left, mid, right массива arr
    public static int medianOfThreeInt(int[] arr, int left, int right){
        int mid = (left + right) / 2;

        if ((arr[left] - arr[mid]) * (arr[right] - arr[left]) >= 0) {
            return arr[left];
        } else if ((arr[mid] - arr[left]) * (arr[right] - arr[mid]) >= 0) {
            return arr[mid];
        } else {
            return arr[right];
        }
    }
    // endregion  QuickSort int




    // region QuickSort generics
    public static <T> void quickSort(Comparator<T> comparator, int left, int right, T ... arr){
        if(left < right){
            int pivotIdx = partition(comparator, left, right, arr);

            //Рекурсивный вызов сортировки для каждой части массива относительно индекса разделения
            quickSort(comparator, left, pivotIdx, arr);
            quickSort(comparator, pivotIdx + 1, right, arr);
        }
    }

    private static <T> int partition(Comparator<T> comparator, int left, int right, T ... arr){
        T pivot = medianOfThree(comparator, left, right, arr); //Вычисление опорного элемента как медианы трёх

        while (left <= right){ //Пока левый и правый индексы не пересекутся:
            while(comparator.compare(arr[left], pivot) < 0){ //Обходить левую часть, пока её элементы меньше опорного
                left++;
            }
            while (comparator.compare(arr[right], pivot) > 0){ //Обходить правую часть, пока её элементы больше опорного
                right--;
            }

            //Если левый и правый индексы пересеклись - выйти
            if(left >= right){
                break;
            }

            //Иначе - поменять местами элемент, который больше опорного и стоит слева от него,
            //с элементом, который меньше опорного и стоит справа
            swap(left++, right--, arr);
        }

        //Вернуть индекс элемента, относительно которого сейчас отсортирован массив
        return right;
    }

    private static <T> void swap(int leftIdx, int rightIdx, T ... arr){
        T tmp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = tmp;
    }

    //Вычисление среднего из значений left, mid, right массива arr
    public static <T> T medianOfThree(Comparator<T> comparator, int left, int right, T ... arr){
        int mid = (left + right) / 2;

        if ( (comparator.compare(arr[left], arr[mid]) * comparator.compare(arr[right], arr[left])) >= 0) {
            return arr[left];
        } else if ( (comparator.compare(arr[mid], arr[left]) * comparator.compare(arr[right], arr[mid])) >= 0){
            return arr[mid];
        } else {
            return arr[right];
        }
    }
    // endregion QuickSort generics
}
