package ru.geekbrains.architecture.lesson3;

public class ServiceStation implements Refueling, Wiping{
    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");

        }
    }

    @Override
    public void wipMirrors() {
        System.out.println("Чистка зеркал выполнена.");
    }

    @Override
    public void wipWindshield() {
        System.out.println("Чистка лобового стекла выполнена.");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Чистка фар выполнена");
    }
}
