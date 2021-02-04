import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 3, Task 1
 */

public class NumberGame {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Угадайте число от 0 до 9 ");
        int answer;
        int tryCount;
        int computerNumber;
        boolean isAnswerCorrect;

        do {

            tryCount = 0;
            computerNumber = random.nextInt(10);
            isAnswerCorrect = false;

            while (tryCount < 3 && !isAnswerCorrect) {
                System.out.println("Введите ваше число: ");

                answer = scanner.nextInt();

                if (answer == computerNumber) {
                    isAnswerCorrect = true;
                    System.out.printf("Ура, вы победили, моё число %d%n", answer);
                } else {
                    System.out.println("Неа");
                }
                tryCount++;
            }
            if (!isAnswerCorrect) {
                System.out.printf("Вы !!НЕ!! победили, моё число было %d%n", computerNumber);
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

        } while (scanner.nextInt() == 1);

        System.out.println("Это конец!");
    }
}
