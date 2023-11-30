package ru.geekbrains.core.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';

    private static final int WIN_COUNT = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static  char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;


    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    static void initialize(){
        fieldSizeY = 5;
        fieldSizeX = 5;

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++){
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int y = 0; y < fieldSizeY; y++){
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++){
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn(){
        int x;
        int y;

        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 3)\nчерез пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn(){
        int x;
        int y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));

        field[y][x] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y){
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка доступности ячейки игрового поля
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x< fieldSizeX && y >= 0 && y < fieldSizeY;
    }


    /**
     * Метод проверки состояния игры
     * @param dot фишка игрока
     * @param s победный слоган
     * @return результат проверки состояния игры
     */
    static boolean checkGameState(char dot, String s){
        if (checkWin(dot)){
            System.out.println(s);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка на ничью
     * @return результат проверки наличия пустого поля
     */
    static boolean checkDraw(){
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Проверка победы игрока
     * @param dot фишка игрока
     * @return признак победы
     */
    static boolean checkWin(char dot){
        if (fieldSizeX == 3 && fieldSizeY == 3) {
            // Проверка по трем горизонталям
            if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
            if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
            if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;

            // Проверка по трем вертикалям
            if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
            if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
            if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;

            // Проверка по диагоналям
            if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
            if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;
        } else {
            return checkHorizontal(dot) || checkVertical(dot) || checkDiagonal(dot);
        }

        return false;
    }

    /**
     * Проверяет все горизонтали на наличие победной комбинации
     * @param dot фишка игрока
     * @return признак победы
     */
    static boolean checkHorizontal(char dot) {
        int dotCount;
        for (int i = 0; i < fieldSizeY; i++) {
            dotCount = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == dot) {
                    dotCount++;
                } else {
                    dotCount = 0;
                }
                if (dotCount >= WIN_COUNT) return true;
            }
        }
        return false;
    }

    /**
     * Проверяет все вертикали на наличие победной комбинации
     * @param dot фишка игрока
     * @return признак победы
     */
    static boolean checkVertical(char dot) {
        int dotCount;
        for (int i = 0; i < fieldSizeY; i++) {
            dotCount = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[j][i] == dot) {
                    dotCount++;
                } else {
                    dotCount = 0;
                }
                if (dotCount >= WIN_COUNT) return true;
            }
        }

        return false;
    }

    /**
     * Проверяет все диагонали на наличие победной комбинации
     * @param dot фишка игрока
     * @return признак победы
     */
    static boolean checkDiagonal(char dot) {
        int dotCount = 0;
        int shiftX = fieldSizeX - WIN_COUNT;
        int shiftY = fieldSizeY - WIN_COUNT;
        int k = 0;

        for (int i = shiftY; i >= 0; i--) {
            k = 0;
            dotCount = 0;
            for (int j = i; j < fieldSizeY; j++) {
                if (field[j][k] == dot) {
                    dotCount++;
                } else {
                    dotCount = 0;
                }
                if (dotCount >= WIN_COUNT) return true;
                k++;
            }
        }

        for (int i = shiftX; i > 0; i--) {
            k = 0;
            dotCount = 0;
            for (int j = i; j < fieldSizeX; j++) {
                if (field[k][j] == dot) {
                    dotCount++;
                } else {
                    dotCount = 0;
                }
                if (dotCount >=WIN_COUNT) return true;
                k++;
            }
        }

        for (int i = fieldSizeY - shiftY - 1; i < fieldSizeY; i++) {
            k = 0;
            dotCount = 0;
            for (int j = i; j >= 0; j--) {
                if (field[j][k] == dot) {
                    dotCount++;
                } else {
                    dotCount = 0;
                }
                if (dotCount >= WIN_COUNT) return true;
                k++;
            }
        }

        for (int i = shiftX; i > 0; i--) {
            k = fieldSizeY - 1;
            dotCount = 0;
            for (int j = i; j < fieldSizeX; j++) {
                if (field[k][j] == dot) {
                    dotCount++;
                } else {
                    dotCount = 0;
                }
                if (dotCount >= WIN_COUNT) return true;
                k--;
            }
        }

        return false;
    }
}
