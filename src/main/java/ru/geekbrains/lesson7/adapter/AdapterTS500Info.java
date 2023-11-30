package ru.geekbrains.lesson7.adapter;

public class AdapterTS500Info implements MeteoSensorSimple {

    private final SensorTemperature sensorTemperature;

    public AdapterTS500Info(SensorTemperature sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }

    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public double getTemperature() {
        return sensorTemperature.temperature();
    }

    /*@Override
    public double getHumidity() {
        return 0;
    }

    @Override
    public double getPressure() {
        return 0;
    }*/
}
