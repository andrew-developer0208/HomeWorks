package ru.geekbrains.lesson4.homework;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    private final ArrayList<T> fruits;
    private final String name;

    /**
     * Constructor
     */
    public Box(String name) {
        fruits = new ArrayList<>();
        this.name = name;
    }

    /**
     * Gets box total weight
     * @return float
     */
    public float getWeight() {
        return fruits.size() > 0 ? fruits.size() * fruits.get(0).getWeight(): 0.0f;
    }

    /**
     * Adds fruit to box
     * @param fruit fruit
     */
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    /**
     * Transfer fruits from this box to destination box
     * @param destination destination box
     */
    public void transfer(Box<T> destination) {
        while (this.fruits.size() > 0) {
            destination.addFruit(this.fruits.get(0));
            this.fruits.remove(0);
        }
    }

    /**
     * Compares the weight of this box with the param
     * @param box instance Box
     * @return boolean
     */
    public boolean compare(Box<?> box) {
        return this.getWeight() - box.getWeight() == 0;
    }

    @Override
    public String toString() {
            return String.format("%s Общий вес: %.1f", name, getWeight());
    }
}