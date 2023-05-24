package src.main.homeworks.hw12.part1;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Task1 {

    /*1. Створити метод countOccurance, що приймає на вхід рядковий список як параметр і довільний рядок.
    Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
    Порахувати скільки разів зустрічається переданий рядок як другий аргумент.*/

    public static final String[] ANIMALS  = {"lion", "tiger", "elephant", "giraffe", "zebra", "kangaroo", "penguin", "dolphin",
            "gorilla", "camel", "rhinoceros", "squirrel", "rabbit", "koala", "panda",
            "alligator", "crocodile", "lemur", "beaver", "chameleon"};

    public static void main(String[] args) {

        List<String> wordList = generateRandomWordsList(ANIMALS);
        String targetWord = wordList.get(new Random().nextInt(wordList.size()));

        System.out.printf("\nArray size %d words:%n", wordList.size());
        printWordListInTwoColumns(wordList);

        System.out.println("\nResult:");
        int count = countOccurrence(wordList, targetWord);
        System.out.println("The word \"" + targetWord + "\" occurs " + count + " times.");

    }

    public static List<String> generateRandomWordsList(String[] words) {

        Random rand = new Random();
        int listSize = rand.nextInt(11) + 10;
        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            wordsList.add(words[rand.nextInt(words.length)]);
        }

        return wordsList;
    }

    public static int countOccurrence(List<String> list, String target) {
        if(list == null) {
            throw new IllegalArgumentException("List should not be null");
        }
        if(target.isBlank()) {
            throw new IllegalArgumentException("The target word cannot be empty or contain only whitespace characters.");
        }

        int count = 0;
        for(String word: list) {
            if(word.equals(target)) {
                count++;
            }
        }

        return count;
    }

    public static void printWordListInTwoColumns(List<String> wordList) {
        for (int i = 0; i < wordList.size(); i += 2) {
            String firstColumn = wordList.get(i);
            String secondColumn = (i + 1) < wordList.size() ? wordList.get(i + 1) : "";
            System.out.printf("%-15s %-15s%n", firstColumn, secondColumn);
        }
    }
}
