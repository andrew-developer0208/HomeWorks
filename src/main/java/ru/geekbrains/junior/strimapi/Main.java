package ru.geekbrains.junior.strimapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ex1();
    }


    /**
     * Потоковые операции
     */
    static void ex1() {
        LinkedList<Integer> list = getRandomList(10, 1, 10);
        System.out.println("Исходный список:\n" + list);

        Stream<Integer> stream = list.stream();
        Optional<Integer> minVal = stream.min(Integer::compare);
        minVal.ifPresent(integer -> System.out.println("Минимальное значение = " + integer));
        stream = list.stream();
        Optional<Integer> maxVal = stream.max(Integer::compare);
        maxVal.ifPresent(x -> System.out.println("Максимальное значение = " + x));

        Stream<Integer> sortedStream = list.stream().sorted();
        System.out.println("Сортированный список:");
        sortedStream.forEach(integer -> System.out.print(" | " + integer));
//        System.out.println();
        System.out.println("\n" + "-".repeat(40));

        System.out.println("Только чётные:");
        Stream<Integer> evenOnly = list.stream().filter(x -> x % 2 == 0);
        evenOnly.forEach(x -> System.out.print(" | " + x));
        System.out.println("\n" + "-".repeat(40));

        int sumValue = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Операция сведения. Сумма элементов = " + sumValue);
        System.out.println("\n" + "-".repeat(40));

        Optional<Integer> multValue = list.stream().reduce((x, y) -> x * y);
        multValue.ifPresent(integer -> System.out.println("Произведение элементов = " + integer));
        System.out.println("\n" + "-".repeat(40));

        System.out.println("Сортированные квадраты только нечётных:");
        list.stream().sorted().filter(x -> x % 2 != 0).forEach(x -> System.out.print(" | " + x * x));

        System.out.println("Квадраты элементов отображаются на новый поток");
        Stream<Double> sqrtList = list.stream().map(a -> Math.sqrt(a));
        sqrtList.forEach(x -> System.out.printf(" | %.2f", x));
        sqrtList = list.stream().map(a -> Math.sqrt(a));
        double multSqrt = sqrtList.reduce(1.0, (x, y) -> x * y);
        System.out.printf("\nПроизведение корней элементов = %.2f", multSqrt);

        Stream<Integer> streamEven = list.stream().filter(x -> x % 2 == 0).map(x -> x * x);
        List<Integer> list1 = streamEven.collect(Collectors.toList());
        System.out.println("\nСписок из потока:\n" + list1);

        streamEven = list.stream().filter(x -> x % 2 == 0).map(x -> x * x);
        Set<Integer> set1 = streamEven.collect(Collectors.toSet());
        System.out.println("\n Множество из потока\n" + set1);
    }

    /**
     * Gets Linkedlist<Integer> with random values
     * @param size int size of list
     * @param min int start diapason
     * @param max int end diapason
     * @return LinkedList<Integer>
     */
    private static LinkedList<Integer> getRandomList(int size, int min, int max) {
        LinkedList<Integer> llist = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            llist.add(rnd.nextInt(max - min + 1) + min);
        }
        return llist;
    }

}