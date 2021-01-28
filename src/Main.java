public class Main {

    public static void main(String[] args) {

        byte b = 1;
        short myShort = 10;
        int i = 67;
        long l = 89889899L;
        float f = 8.999999F;
        double d = 989.123214143123;

        char myChar = 'U';
        String myStringOne = "This is string";

        System.out.println("--task 3");
        System.out.println(calculateOne(5, 87, 34, 0));
        System.out.println(calculateOne(32, 11, 56, 25));

        System.out.println("--task 4");
        System.out.println(isInRange(1, 3));
        System.out.println(isInRange(9, 9));

        System.out.println("--task 5");
        isPositiveToConsole(5);
        isPositiveToConsole(-205);

        System.out.println("--task 6");
        System.out.println("Is number 5 negative: " + isNegative(5));
        System.out.println("Is number -87 negative: " + isNegative(-87));

        System.out.println("--task 7");
        printHello("Андрей");

        System.out.println("--task 8");
        isLeapYear(2020);
        isLeapYear(2021);
        isLeapYear(1776);
        isLeapYear(1960);
        isLeapYear(1925);

    }

    // Task 3
    static float calculateOne(float a, float b, float c, float d) {
        if (d == 0) {
            System.out.println("Divide by zero!");
            return 0;
        }
        return a * (b + (c / d));
    }

    // Task 4
    static boolean isInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Task 5

    static void isPositiveToConsole(int a) {
        if (a >= 0) {
            System.out.println(a + " is positive");
        } else {
            System.out.println(a + " is negative");
        }
    }

    // Task 6
    static boolean isNegative(int a) {
        return a < 0;
    }

    // Task 7
    static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // Task 8
    static void isLeapYear(int year) {
        boolean isLeap = false;
        if (year % 400 == 0) {
            isLeap = true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            isLeap = true;
        }
        if (isLeap) {
            System.out.println(year + " год високосный");
        } else {
            System.out.println(year + " год не високосный");
        }
    }
}
