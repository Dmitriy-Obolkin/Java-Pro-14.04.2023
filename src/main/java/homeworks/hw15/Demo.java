package homeworks.hw15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Demo  {
    public static void main(String[] args) {
        System.out.println("\nQuickSort int:");

        int[] arr = new int[] {7, 1, 3, 2, -2, 16, 4, 6, 3};
        MyQuickSort.quickSortIntArray(arr, 0, arr.length-1);
        System.out.println("sorted array1: " + Arrays.toString(arr));

        Random rand = new Random();
        int[] arr2 = new int[50];
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = rand.nextInt(101);
        }
        System.out.println("random array2: " + Arrays.toString(arr2));
        MyQuickSort.quickSortIntArray(arr2, 0, arr2.length-1);
        System.out.println("sorted array2: " + Arrays.toString(arr2));





        System.out.println("\nShakerSort int:");

        int[] arr3 = new int[] {7, 1, 3, 2, -2, 16, 4, 6, 3};
        MyShakerSort.shakerSortIntArray(arr3);
        System.out.println("sorted array1: " + Arrays.toString(arr3));

        int[] arr4 = new int[50];
        for(int i = 0; i < arr4.length; i++) {
            arr4[i] = rand.nextInt(101);
        }
        System.out.println("random array3: " + Arrays.toString(arr4));
        MyShakerSort.shakerSortIntArray(arr4);
        System.out.println("sorted array3: " + Arrays.toString(arr4));
        System.out.println();





        System.out.println("\nQuickSort generics:");

        Student anna = new Student("Anna", 22);
        Student petro = new Student("Petro", 35);
        Student ivan = new Student("Ivan", 48);
        Student vasyl = new Student("Vasyl", 21);
        Student olha = new Student("Olha", 31);
        Student maxim = new Student("Maxim", 37);

        Student[] students = new Student[] {
                anna, petro, ivan, vasyl, olha, maxim
        };

        System.out.println("\nUnsorted Students array: \n" + Arrays.toString(students));
        Comparator<Student> ageComparator = (s1, s2) -> s1.getAge() - s2.getAge(); //or Comparator.comparingInt(Student::getAge);
        MyQuickSort.quickSort(ageComparator, 0, students.length-1, students);
        System.out.println("\nThe array Students sorted by age: \n" + Arrays.toString(students));
        System.out.println();





        System.out.println("\nShakerSort generics:");

        String[] strArray = new String[] {"dog", "cat", "zebra", "lion", "tiger", "elephant", "monkey", "Tiger", "giraffe", "dog", "horse"};
        MyShakerSort.shakerSort(strArray);
        System.out.println(Arrays.toString(strArray));
    }
}
