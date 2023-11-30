package ru.geekbrains.lesson7.adapter;

public interface MeteoSensor {

    int getId(); // Идентификатор датчика
    double getTemperature(); // Температура
    double getHumidity(); // Влажность
    double getPressure(); // Давление

}
