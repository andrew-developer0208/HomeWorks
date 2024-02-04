package ru.geekbrains.junior.hw2;

public abstract class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Class: %s  name: %s  age: %d", this.getClass().getSimpleName(), name, age);
    }

    /**
     * Имитирует звуки, издаваемые животным
     */
    public abstract void makeSound();
}
