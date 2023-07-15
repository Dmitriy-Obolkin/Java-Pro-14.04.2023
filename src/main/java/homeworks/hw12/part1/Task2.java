package homeworks.hw12.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    /*2. Створити метод toList, що приймає на вхід цілісний масив довільної довжини. Конвертувати масив
      у список відповідного типу даних та повернути з методу.
      Наприклад:
          Було Array [1, 2, 3]
          Стало List [1, 2, 3]
    */

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        List<Integer> list1 = toList1(array);
        List<Integer> list2 = toList2(array);
        System.out.println(list1);
        System.out.println(list2);
    }

    public static <T> List<T> toList1(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    public static <T> List<T> toList2(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }


}
