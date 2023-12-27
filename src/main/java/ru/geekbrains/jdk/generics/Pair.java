package ru.geekbrains.jdk.generics;

public class Pair<T, V> {

    private  T first;
    private V second;

    /**
     * Constructor
     * @param first
     * @param second
     */
    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Возвращает первый объект
     * @return T
     */
    public T getFirst() {
        return first;
    }

    /**
     * Возвращает второй объект
     * @return V
     */
    public V getSecond() {
        return second;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("first type: %s; second type: %s",
                first.getClass().getSimpleName(),
                second.getClass().getSimpleName());
    }
}
