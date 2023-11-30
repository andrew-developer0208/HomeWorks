package ru.geekbrains.lesson7.singleton;

public class Program {

    /**
     * Entry point
     * @param args
     */
    public static void main(String[] args) {

        // Создаём первый объект и присваиваем значения его параметрам

        Singleton singleton1 = Singleton.getInstance();
        singleton1.setParam1("same parameter");
        singleton1.setParam2(32);

        // Создаём второй объект и выводим значения его параметров

        Singleton singleton2 = Singleton.getInstance();
        System.out.printf("param1 = %s | param2 = %d", singleton2.getParam1(), singleton2.getParam2());

    }

}
