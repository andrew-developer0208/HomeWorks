package ru.geekbrains.lesson7.adapter;

public class ST500Info implements SensorTemperature {


    private int id;

    public ST500Info(int id) {
        this.id = id;
    }

    @Override
    public int identifier() {
        return id;
    }

    @Override
    public double temperature() {
        return -15;
    }
}
