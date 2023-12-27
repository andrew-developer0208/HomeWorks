package ru.geekbrains.jdk.generics;

import ru.geekbrains.core.lesson4.presenter.Validator;

public class Calculator {

    /**
     * Складывает два числа
     * @param first первое число
     * @param second второе число
     * @param <T> тип параметров, ограниченный Number
     * @return double
     */
    public static<T extends Number, V extends Number> double sum(T first, V second) {
        return  first.doubleValue() + second.doubleValue();
    }

    /**
     * Вычитает второе число из первого
     * @param first первое число
     * @param second второе число
     * @param <T> тип параметров, ограниченный Number
     * @return double
     */
    public static<T extends Number, V extends Number> double subtract(T first, V second) {
        return first.doubleValue() - second.doubleValue();
    }

    /**
     * Перемножает два числа
     * @param first первое число
     * @param second второе число
     * @param <T> тип параметров, ограниченный Number
     * @return double
     */
    public static<T extends Number, V extends Number> double multiply(T first, V second) {
        return first.doubleValue() * second.doubleValue();
    }

    /**
     * Делит первое число на второе
     * @param first первое число
     * @param second второе число
     * @param <T> тип параметров, ограниченный Number
     * @return double
     */
    public static<T extends Number, V extends Number> double divide(T first, V second) {
        if (second.doubleValue() == 0) {
            throw new RuntimeException("Попытка деления на ноль");
        }
        return first.doubleValue() / second.doubleValue();
    }

    /**
     * Сравнивает два массива на равенство, попарно сравнивая элементы
     * @param firstArray первый массив
     * @param secondArray второй массив
     * @param <T> тип элементов первого массива
     * @param <V> тип элементов второго массива
     * @return результат проверки
     */
    public static<T, V> boolean compareArrays(T[] firstArray, V[] secondArray) {
        if (firstArray.length == secondArray.length) {
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i].getClass() != secondArray[i].getClass()) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

}
