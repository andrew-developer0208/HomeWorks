package ru.geekbrains.jdk.generics;

public class program {
    public static void main(String[] args) {

        System.out.println("\ntask-1\n------");
        int a = 12;
        double b = 15;
        System.out.printf("Сумма чисел %d и %.2f = %.2f\n",a ,b ,Calculator.sum(a, b));
        System.out.printf("Разность чисел %d и %.2f = %.2f\n",a ,b ,Calculator.subtract(a, b));
        System.out.printf("Произведение чисел %d и %.2f = %.2f\n",a ,b ,Calculator.multiply(a, b));
        System.out.printf("Частное от деления числа %d на %.2f = %.2f\n",a ,b ,Calculator.divide(a, b));

        System.out.println();

        System.out.println("\ntask-2\n------");
        System.out.println("Проверяем \"одинаковые\" массивы:");
        Object[] array1 = new Object[] {1, 5, 7, "4"};
        Object[] array2 = new Object[] {1, 2, 3, "4"};
        System.out.println(Calculator.compareArrays(array1, array2));

        System.out.println("Проверяем \"неодинаковые\" массивы:");
        Object[] array3 = new Object[] {1, 2, 3, "4"};
        Object[] array4 = new Object[] {1, "2", 3, "4"};
        System.out.println(Calculator.compareArrays(array3, array4));

        System.out.println();

        System.out.println("\ntask-3\n------");
        Pair<Integer, String> pair = new Pair<>(88, "Обобщения");
        System.out.println(pair);
    }
}
