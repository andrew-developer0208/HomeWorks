package ru.geekbrains.junior.hw1;

import java.util.Arrays;
import java.util.List;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 6, 7, 11, 13, 17, 19, 20);

        int sumEven = list.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
        int countEven = (int) list.stream().filter(x -> x % 2 == 0).count();
        double average = (double) sumEven / countEven;

        System.out.printf("Среднее арифметическое всех чётных: %.2f", average );
    }
}
