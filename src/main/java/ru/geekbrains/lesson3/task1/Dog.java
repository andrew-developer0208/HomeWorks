package ru.geekbrains.lesson3.task1;

public class Dog extends Animal{

    private static int counter;

    public static int getCounter() {
        return counter;
    }

    {
        counter++;
    }

    public Dog(String name, int maxSwim, int maxRun) {
        super(name, maxSwim, maxRun);
    }


}
