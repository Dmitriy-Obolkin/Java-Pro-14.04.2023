package src.main.homeworks.hw7;

import java.util.Random;
import java.util.Scanner;

public class HW7Service {

    //2
    public static int findSymbolOccurance(String str, char symbol){
        System.out.println("\n2:");
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }

        return count;
    }

    //3
    public static int findWordPosition(String source, String target) {
        System.out.println("\n3:");
        int index = source.indexOf(target);
        if (index != -1) {
            return index;
        } else {
            return -1;
        }
    }

    //4
    public static String stringReverse(String str) {
        System.out.println("\n4:");
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
    //4_2
    public static String stringReverse2(String str) {
        System.out.println("\n4_2:");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    //4_3
    public static String stringReverse3(String str) {
        System.out.println("\n4_3:");
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    //5
    public static boolean isPalindrome(String str) {
        System.out.println("\n5:");
        int leftIndex = 0;
        int rightIndex = str.length() - 1;
        while (leftIndex < rightIndex) {
            char leftChar = Character.toLowerCase(str.charAt(leftIndex));
            char rightChar = Character.toLowerCase(str.charAt(rightIndex));
            if (leftChar != rightChar) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    //6
    public static void playGame(String[] words){
        System.out.println("\n6:");

        String secretWord = getRandomWord(words);
        String userAnswer = new String();
        Scanner sc = new Scanner(System.in);
        StringBuilder hint = new StringBuilder("###############");

        do{
            System.out.print("Enter your word: ");
            userAnswer = sc.nextLine().toLowerCase();

            if(userAnswer.equals(secretWord)){
                System.out.println("Congratulations! You guessed the word!");
                break;
            }
            else {
                /*Сверить посимвольно secretWord и userAnswer, пока не пройдём полностью одно из слов*/
                for (int i = 0; i < userAnswer.length() && i < secretWord.length(); i++) {
                    if (userAnswer.charAt(i) == secretWord.charAt(i)) {
                        hint.setCharAt(i, userAnswer.charAt(i));
                    }
                }
                System.out.println("Hint: " + hint);
            }
        }
        while (userAnswer != secretWord);

        sc.close();
    }

    public static String getRandomWord(String[] words){
        if (words == null || words.length == 0) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}
