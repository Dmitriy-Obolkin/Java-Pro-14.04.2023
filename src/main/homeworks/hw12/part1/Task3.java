package src.main.homeworks.hw12.part1;


import java.util.*;

public class Task3 {

    /*3. Створити метод findUnique, що приймає на вхід числовий список, що складається з довільних значень,
    які можуть повторюватися в необмеженій кількості. Необхідно повернути новий числовий список,
    що містить тільки унікальні числа.
     * */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 2, 5, 1, 4, 5, 3, 1, 5);
        List<Integer> uniqueList = findUnique(list);
        System.out.println(uniqueList);

        List<Integer> uniqueList2 = findUnique2(list);
        System.out.println(uniqueList2);
    }

    public static List<Integer> findUnique(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer number : list) {
            if (!uniqueList.contains(number)) {
                uniqueList.add(number);
            }
        }
        return uniqueList;
    }

    public static List<Integer> findUnique2(List<Integer> list) {
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }
}
