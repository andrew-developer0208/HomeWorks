package ru.geekbrains.lesson4.homework;

public abstract  class Fruit {


    private final float weight;

    /**
     * Constructor
     * @param weight fruit weight
     */
    public Fruit(float weight) {
        this.weight = weight;
    }

    /**
     * Gets fruit weight
     * @return this.weight
     */
    public float getWeight() {
        return weight;
    }
}
