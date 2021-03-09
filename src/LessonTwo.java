public class LessonTwo {

    public static void main(String[] args) {
        System.out.println("---Task 1---");
        replaceZeroOne();
        System.out.println("---Task 2---");
        fillArrayAuto();
        System.out.println("---Task 3---");
        multipleArrayElements();
        System.out.println("---Task 4---");
        fillMatrixByDiagonal();
        System.out.println("---Task 5---");
        findMixMax();


        System.out.println("---Task 6---");
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{1, 5, 1, 2, 10}));


        System.out.println("---Task 7---");
        System.out.println("shift to 3");
        shiftArray(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println("---------");
        System.out.println("shift to 7");
        shiftArray(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println("---------");
        System.out.println("shift to 5");
        shiftArray(new int[]{1, 2, 3, 4, 5}, 5);
        System.out.println("---------");
        System.out.println("shift to -3");
        shiftArray(new int[]{1, 2, 3, 4, 5}, -3);
        System.out.println("---------");
        System.out.println("shift to -7");
        shiftArray(new int[]{1, 2, 3, 4, 5}, -7);
        System.out.println("---------");
        System.out.println("shift to 16");
        shiftArray(new int[]{1, 2, 3, 4, 5}, 16);
        System.out.println("---------");
    }

    /**
     * Task 1
     */

    static void replaceZeroOne() {
        int[] zeroOneArray = new int[]{1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1};
        printArray(zeroOneArray);

        for (int i = 0; i < zeroOneArray.length; i++) {
            if (zeroOneArray[i] == 1) {
                zeroOneArray[i] = 0;
            } else {
                zeroOneArray[i] = 1;
            }
        }

        printArray(zeroOneArray);
    }

    /**
     * Task 2
     */

    static void fillArrayAuto() {
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }

        printArray(arr);
    }

    /**
     * Task 3
     */

    static void multipleArrayElements() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        printArray(array);
    }

    /**
     * Task 4
     */

    static void fillMatrixByDiagonal() {
        int[][] matrix = new int[10][10];
        int pos1 = 0;
        int pos2 = matrix.length - 1;

        int i;
        for (i = 0; i < matrix.length; i++) {
            matrix[i][pos1++] = 1;
            matrix[i][pos2--] = 1;
        }

        for (i = 0; i < matrix.length; i++) {
            printArray(matrix[i]);
        }

    }

    /**
     * Task 5
     */


    static void findMixMax() {
        int[] array = new int[]{87, 23, 101, 76, 21, 5, 73, 32, 12};
        printArray(array);
        int min = array[0];
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("MIN element is " + min);
        System.out.println("MAX element is " + max);
    }


    /**
     * Task 6
     */

    static boolean checkBalance(int[] array) {
        int sumLeft = 0;

        for (int i = 0; i < array.length; i++) {
            sumLeft += array[i];
            int sumRight = 0;

            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
            }

            if (sumLeft == sumRight) {
                return true;
            }
        }

        return false;
    }


    /**
     * Task 7
     */
    static void shiftArray(int[] array, int directionAndCount) {
        int trueDirection = directionAndCount > 0 ? 1 : -1;
        int trueShiftCount = directionAndCount * trueDirection;

        //Узнаём только значимое количество сдвигов, чтобы не крутить лишний раз по кругу
        if (trueShiftCount >= array.length) {
            trueShiftCount %= array.length;
        }

        if (trueShiftCount == 0) {
            printArray(array);
        } else {
            for (int c = 0; c < trueShiftCount; c++) {
                int tmp;
                int t;

                if (trueDirection > 0) {
                    tmp = array[array.length - 1];
                    for (int i = 0; i < array.length; i++) {
                        t = array[i];
                        array[i] = tmp;
                        tmp = t;
                    }
                } else {
                    tmp = array[0];

                    for (int i = array.length - 1; i >= 0; i--) {
                        t = array[i];
                        array[i] = tmp;
                        tmp = t;
                    }
                }
            }

            printArray(array);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }
}
