import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final char FREE_SIGN = '_';
    static final char AI_SIGN = 'O';
    static final char PLAYER_SIGN = 'X';

    static final int KEY_FREE_CELL_COUNT = 0;
    static final int KEY_MAX_PLAYER_STREAK = 1;
    static final int KEY_PLAYER_SIGN_COUNT = 2;
    static final int KEY_LINE_LENGTH = 3;
    static final int KEY_AI_SIGN_COUNT = 4;

    public static void main(String[] args) {
        playGame(4, 4);
    }

    static void playGame(int fieldSize, int winStreak) {
        char[][] field = prepareField(fieldSize);
        printField(field);
        while (true) {
            if (!checkNextPlayerMove(field, winStreak)) {
                return;
            }

            if (!checkNextAIMove(field, winStreak)) {
                return;
            }
        }

    }

    static boolean checkNextPlayerMove(char[][] field, int winStreak) {
        doPlayerTurn(field);
        printField(field);
        return isNextMoveAvailable(field, winStreak, PLAYER_SIGN, "You are winner");
    }

    static boolean checkNextAIMove(char[][] field, int winStreak) {
        doAIMove(field, winStreak);
        printField(field);
        return isNextMoveAvailable(field, winStreak, AI_SIGN, "Sorry, AI is winner!");
    }


    static void doPlayerTurn(char[][] field) {
        int x, y;
        do {
            x = readAndCheckPosition(String.format("Please enter X coord (1..%d) ...", field.length), field.length);
            y = readAndCheckPosition(String.format("Please enter Y coord (1..%d) ...", field.length), field.length);
        } while (!isCellEmpty(field, x, y));
        field[x][y] = PLAYER_SIGN;
    }

    static boolean isNextMoveAvailable(char[][] field, int winStreak, char sign, String winMessage) {
        if (isWin(field, winStreak, sign)) {
            System.out.println(winMessage);
            return false;
        }

        if (isDraw(field)) {
            System.out.println("There is draw detected. Finish!");
            return false;
        }

        return true;
    }

    // Генератор набора параметров для проверки всех диагоналей и прямых на поле
    static int[][] getParamsCombinationForAnalize(int length, int i) {

        return new int[][]{
                {0, i, 1, -1},
                {0, i, 1, 1},
                {0, i, 1, 0},
                {i, 0, 0, 1},

                {length - 1, i, -1, 1},
                {length - 1, i, -1, -1},
        };
    }

    static int[] doAIRandomMove(char[][] field) {
        System.out.println("AI do random");
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (!isCellEmpty(field, x, y));
        return new int[]{x, y};
    }

    static void doAIMove(char[][] field, int winStreak) {
        int suitableWinCount = winStreak;
        int[] aiMovePosition;

        do {
            suitableWinCount -= 1;

            for (int i = 0; i < field.length; i++) {
                int[][] params = getParamsCombinationForAnalize(field.length, i);

                for (int l = 0; l < params.length; l++) {
                    int[] analizeLineResult = analizeLineForAI(field, params[l][0], params[l][1], params[l][2], params[l][3]);



                    //Если линия близка к победе игрока
                    if ((analizeLineResult[KEY_MAX_PLAYER_STREAK] == suitableWinCount)

                    || (field.length == winStreak && analizeLineResult[KEY_PLAYER_SIGN_COUNT]
                            - analizeLineResult[KEY_AI_SIGN_COUNT]
                            >= suitableWinCount)) {
                        //Если на линии хватает клеток для победной комбинации
                        if (analizeLineResult[KEY_LINE_LENGTH] >= winStreak) {
                            //Если на линии есть пустые клетки
                            if (analizeLineResult[KEY_FREE_CELL_COUNT] > 0
                                    && analizeLineResult[KEY_FREE_CELL_COUNT] + analizeLineResult[KEY_PLAYER_SIGN_COUNT] >= suitableWinCount

                            ) {
//                                printDebug(analizeLineResult, params, l);
                                aiMovePosition = findCellForAIOnLine(field, params[l][0], params[l][1], params[l][2], params[l][3]);
                                field[aiMovePosition[0]][aiMovePosition[1]] = AI_SIGN;
                                return;
                            }
                        }
                    }
                }
            }
        } while (suitableWinCount >= 0);
        aiMovePosition = doAIRandomMove(field);
        field[aiMovePosition[0]][aiMovePosition[1]] = AI_SIGN;
    }

    static void printDebug(int[] analizeLineResult, int[][] params, int l){
        System.out.printf("AI choose line [%d][%d] -> [+%d][+%d]%n", params[l][0], params[l][1], params[l][2], params[l][3]);
        System.out.printf("[KEY_FREE_CELL_COUNT] - %d%n", analizeLineResult[KEY_FREE_CELL_COUNT]);
        System.out.printf("[KEY_MAX_PLAYER_STREAK] - %d%n", analizeLineResult[KEY_MAX_PLAYER_STREAK]);
        System.out.printf("[KEY_PLAYER_SIGN_COUNT] - %d%n", analizeLineResult[KEY_PLAYER_SIGN_COUNT]);
        System.out.printf("[KEY_LINE_LENGTH] - %d%n", analizeLineResult[KEY_LINE_LENGTH]);
        System.out.printf("[KEY_AI_SIGN_COUNT] - %d%n", analizeLineResult[KEY_AI_SIGN_COUNT]);
        System.out.println();
    }

    static int[] findCellForAIOnLine(char[][] field, int startX, int startY, int incX, int incY) {
        int maxSuccessCellCount = 8;
        int checkPosX;
        int checkPosY;

        while (maxSuccessCellCount >= 0) {
            checkPosX = startX;
            checkPosY = startY;

            while (checkPosX >= 0 && checkPosX < field.length
                    && checkPosY >= 0 && checkPosY < field.length) {
                int cellsAround = countSingAroundCell(field, checkPosX, checkPosY, PLAYER_SIGN);

                if (isCellEmpty(field, checkPosX, checkPosY) &&
                        cellsAround == maxSuccessCellCount) {
                    return new int[]{checkPosX, checkPosY};

                }
                checkPosX += incX;
                checkPosY += incY;
            }
            maxSuccessCellCount -= 1;
        }

        return doAIRandomMove(field);

    }

    static int countSingAroundCell(char[][] field, int x, int y, char sign) {
        int checkPosX;
        int checkPosY;
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                checkPosX = x + i;
                checkPosY = y + j;
                if ((checkPosX >= 0 && checkPosX < field.length
                        && checkPosY >= 0 && checkPosY < field.length)) {
                    if (field[checkPosX][checkPosY] == sign) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    //Проверяем все диагонали на победу, так как количество фишек для победы может быть меньше ширины поля
    static boolean isWin(char[][] field, int winStreak, char sign) {

        //Проходим по верху матрицы и смотрим диагонали в обе стороны от каждой ячейки
        for (int i = 0; i < field.length; i++) {
            if (isLineWins(field, sign, winStreak, 0, i, 1, -1) ||
                    isLineWins(field, sign, winStreak, 0, i, 1, 1)) {
                return true;
            }
        }

        //Проходим по низу матрицы (так как просмотр тольк сверху перекрывает не весь диапазон) и смотрим диагонали
        // в обе стороны от каждой ячейки
        for (int i = 0; i < field.length; i++) {
            if (isLineWins(field, sign, winStreak, field.length - 1, i, -1, 1) ||
                    isLineWins(field, sign, winStreak, field.length - 1, i, -1, -1)) {
                return true;
            }
        }

        //Проходим по вертикали и горизонтали
        for (int i = 0; i < field.length; i++) {
            if (isLineWins(field, sign, winStreak, i, 0, 0, 1) ||
                    isLineWins(field, sign, winStreak, 0, i, 1, 0)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Сканирует линию на поле в заданном направлении
     *
     * @param field  - игровое поле
     * @param startX -стартовая позиция линии по X
     * @param startY -стартовая позиция линии по Y
     * @param incX   - инкремент по X
     * @param incY   - инкремент по Y
     * @return Массив с результатом сканирования
     * [KEY_FREE_CELL_COUNT] - количество свободных клеток на линии
     * [KEY_MAX_STREAK] - максимально длинная последовательность из символов sign
     * [KEY_SIGN_COUNT] - количество символов sign на линии
     */
    static int[] analizeLineForAI(char[][] field, int startX, int startY, int incX, int incY) {
        int[] result = new int[5];
        int tmpStreak = 0;

        while (startX >= 0 && startX < field.length
                && startY >= 0 && startY < field.length) {

            //Считаем пустые клетки
            if (field[startX][startY] == FREE_SIGN) {
                result[KEY_FREE_CELL_COUNT] += 1;
                tmpStreak = 0;
            }

            //Считаем клетки ИИ
            if (field[startX][startY] == AI_SIGN) {
                result[KEY_AI_SIGN_COUNT] += 1;
            }

            //Считаем клетки игрока и самую длинную комбинацию из последовательности фишек
            if (field[startX][startY] == PLAYER_SIGN) {
                tmpStreak += 1;
                result[KEY_PLAYER_SIGN_COUNT] += 1;
            }

            //Запоминаем максимальную выигрышную последовательность игрока
            if (tmpStreak > result[KEY_MAX_PLAYER_STREAK]) {
                result[KEY_MAX_PLAYER_STREAK] = tmpStreak;
            }

            result[KEY_LINE_LENGTH] += 1;

            startX += incX;
            startY += incY;


        }
        return result;
    }

    static boolean isLineWins(char[][] field, char sign, int winStreak, int startX, int startY, int incX, int incY) {
        int tmpStreak = 0;

        while (startX >= 0 && startX < field.length
                && startY >= 0 && startY < field.length) {

            if (field[startX][startY] == sign) {
                if (++tmpStreak >= winStreak) {
                    return true;
                }
            } else {
                tmpStreak = 0;
            }
            startX += incX;
            startY += incY;

        }
        return false;
    }

    static boolean markLine(char[][] field, int startX, int startY, int incX, int incY) {
        int tmpStreak = 0;

        while (startX >= 0 && startX < field.length
                && startY >= 0 && startY < field.length) {

            field[startX][startY] = 'C';
            startX += incX;
            startY += incY;
        }
        return false;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == FREE_SIGN) {
                    return false;
                }
            }
        }
        System.out.println("Draw detected");
        return true;
    }

    static int readAndCheckPosition(String message, int size) {
        int answer;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(message);
            answer = scanner.nextInt() - 1;
        } while (answer < 0 || answer >= size);
        return answer;
    }

    static boolean isCellEmpty(char[][] field, int i, int j) {
        return field[i][j] == FREE_SIGN;
    }

    static char[][] prepareField(int size) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = FREE_SIGN;
            }
        }
        return field;
    }

    static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
