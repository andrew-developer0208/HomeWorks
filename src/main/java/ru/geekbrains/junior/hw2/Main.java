package ru.geekbrains.junior.hw2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Создайте абстрактный класс "Animal" с полями "name" и "age".
 * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat")
 * с уникальными полями и методами.
 *
 * Создайте массив объектов типа "Animal" и с использованием Reflection API
 * выполните следующие действия:
 *
 * - Выведите на экран информацию о каждом объекте.
 * - Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = Arrays.asList(
                new Cat("Tom", 2),
                new Dog("Dik", 5),
                new Cat("Barsic", 1),
                new Cat("Murzic", 5),
                new Dog("Polkan", 3),
                new Dog("Tison", 10)
        );

        animals.forEach(animal -> {
            System.out.println(animal);

            System.out.println("Аннотации:");
            System.out.println(getAnnotations(animal.getClass()));

            System.out.println("Конструкторы:");
            System.out.println(getConstructors(animal.getClass()));

            System.out.println("Все методы, определённые в классе:");
            System.out.println(getMethods(animal.getClass()));

            System.out.println("Все поля, обявленные в классе:");
            System.out.println(getDeclaredFields(animal.getClass()));

            System.out.println("Все публичные поля:");
            System.out.println(getFields(animal.getClass()));


            try {
                Method method = animal.getClass().getDeclaredMethod("makeSound");
                method.invoke(animal);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                System.out.println(animal.name + "has not makeSound");;
            }
            System.out.println("-".repeat(50) + "\n");


        });
    }

    /**
     * Возвращает аннотации переданного класса
     * @param clazz класс
     * @return String
     */
    private static String getAnnotations(Class<?> clazz) {
        StringBuilder result = new StringBuilder();
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        Arrays.stream(annotations).forEach(annotation -> result.append(annotation).append("\n"));
        return result.toString();
    }


    /**
     * Возвращает конструкторы переданного класса
     * @param clazz класс
     * @return String
     */
    private static String getConstructors(Class<?> clazz) {
        StringBuilder result = new StringBuilder();
        Constructor[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(constructor -> result.append(constructor).append("\n"));
        return result.toString();
        }

    /**
     * Возвращает методы, определённые в переданнм классе
     * @param clazz класс
     * @return String
     */
    private static String getMethods(Class<?> clazz) {
        StringBuilder result = new StringBuilder();
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> result.append(method).append("\n"));
        return result.toString();
        }

    /**
     * Возвращает поля определённые в классе
      * @param clazz
     * @return
     */
    private static String getDeclaredFields(Class<?> clazz) {
        StringBuilder result = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> result.append(field).append("\n"));
        return result.toString();

    }

    /**
     * Возвращает все публичные поля
     * @param clazz
     * @return
     */
    private static String getFields(Class<?> clazz) {
        StringBuilder result = new StringBuilder();
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(field -> result.append(field).append("\n"));
        return result.toString();

    }




}

