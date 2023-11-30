package ru.geekbrains.lesson3.task1;

/**
 *     Создать классы Собака и Кот с наследованием от класса Животное.
 *     Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 *     Результатом выполнения действия будет печать в консоль. (Например, dog1.run(150); -> 'Бобик пробежал 150 м.');
 *     У каждого животного есть ограничения на действия
 *     (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 *     Добавить подсчет созданных котов, собак и животных.
 */
public class Program {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик", 100);
        cat1.run(50);
        System.out.println(cat1.getId());

        Cat cat2 = new Cat("Персик", 200);
        cat2.run(150);
        System.out.println(cat2.getId());

        Cat cat3 = new Cat("Бублик", 300);
        cat3.run(200);
        System.out.println(cat3.getId());

        Dog dog1 = new Dog("Шарик", 200, 1000);

        Dog dog2 = new Dog("Тузик", 210, 900);

        System.out.printf("Было создано %d котов.\n", Cat.getCounter());
        System.out.printf("Было создано %d собак.\n", Dog.getCounter());
        System.out.printf("Было создано %d животных.\n", Animal.getCounter());

    }

}
