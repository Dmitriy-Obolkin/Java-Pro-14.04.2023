package src.main.homeworks.hw12.part1;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Task4_2 {

    /*
    * 4. *** Створити метод calcOccurrence, що приймає на вхід рядковий список як параметр.
    * Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
    * Обчислити скільки разів трапляється кожне слово. Результат повернути у вигляді списку структур,
    * що описують повторення кожного окремого взятого слова.
      Наприклад:
            [
            {name: "bird", occurrence: 2},
            {name: "fox", occurrence: 1},
            {name: "cat", occurrence: 1}
            ]
    */

    public static void main(String[] args) {
        List<String> wordList = Task1.generateRandomWordsList(Task1.ANIMALS);
        System.out.printf("\nArray size %d words:%n", wordList.size());
        Task1.printWordListInTwoColumns(wordList);

        System.out.println("\nResult:");
        List<WordOccurrence> occurrences = calcOccurrence(wordList);

        for(WordOccurrence occurrence : occurrences) {
            System.out.println("{name: \"" + occurrence.word + "\", occurrence: " + occurrence.count + "}");
        }
    }

    //Структура, що описує повторення кожного окремого взятого слова.
    public static class WordOccurrence {
        String word;
        int count;

        public WordOccurrence(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static List<WordOccurrence> calcOccurrence(List<String> list) {
        if(list == null) {
            throw new IllegalArgumentException("List should not be null");
        }

        Map<String, Integer> map = new HashMap<>();

        for(String word: list) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<WordOccurrence> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }

        return result;
    }


}
