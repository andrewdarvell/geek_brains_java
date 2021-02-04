import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 3, Task 2
 */

public class WordsGame {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int wordIndex;
        String playerAnswer;

        do {
            System.out.println("Я загадал слово - угадывай");
            wordIndex = random.nextInt(words.length - 1);
            do {
                playerAnswer = scanner.next();
                if (words[wordIndex].equals(playerAnswer)) {
                    System.out.printf("Угадал, моё слово: %s%n", words[wordIndex]);
                } else {
                    System.out.println("Неа");
                    printHint(words[wordIndex], playerAnswer);
                }

            } while (!words[wordIndex].equals(playerAnswer));
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (scanner.nextInt() == 1);

    }

    static void printHint(String compWord, String answer) {
        System.out.println("Подсказочка (возможно там есть ваши буквы):");
        char charToPrint;

        for (int i = 0; i < 15; i++) {
            charToPrint = '#';
            if ((i < compWord.length() && i < answer.length())
                    && (compWord.charAt(i) == answer.charAt(i))) {
                charToPrint = compWord.charAt(i);
            }
            System.out.print(charToPrint);
        }
        System.out.println();
    }
}
