package ru.geekbrains.lesson7.adapter;

public class Program {

    public static void main(String[] args) {
        MS200 ms200 = new MS200(55);
        ST500Info st500Info = new ST500Info(56);
        MeteoStore meteoStore = new MeteoStore();
        meteoStore.save(ms200);
        meteoStore.save(new AdapterTS500Info(st500Info));
    }

}
