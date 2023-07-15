package homeworks.hw12.part1;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Task4_1 {

    /*
    * 4. ** Створити метод calcOccurrence, який приймає на вхід рядковий список як параметр.
    * Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
    * Обчислити скільки разів трапляється кожне слово. Результат вивести у консоль.
      Наприклад:
            bird: 2
            fox: 1
            cat: 1
     */

    public static void main(String[] args) {
        List<String> wordList = Task1.generateRandomWordsList(Task1.ANIMALS);
        System.out.printf("\nArray size %d words:%n", wordList.size());
        Task1.printWordListInTwoColumns(wordList);

        System.out.println("\nResult:");
        calcOccurrence(wordList);
    }

    public static void calcOccurrence(List<String> list) {
        if(list == null) {
            throw new IllegalArgumentException("List should not be null");
        }

        Map<String, Integer> map = new HashMap<>();

        for(String word: list) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
