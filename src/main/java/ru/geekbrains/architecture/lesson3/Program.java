package ru.geekbrains.architecture.lesson3;

import ru.geekbrains.architecture.lesson3.RefuelingStation;
import ru.geekbrains.architecture.lesson3.SportCar;

import java.awt.*;

public class Program {


    public static void main(String[] args) {

        // Создадим спорткар
        Car lambo = SportCar.create("lamborghini", "diablo", Color.BLACK, 4);
        System.out.printf("\n%s\n", lambo);

        // Создадим заправочную станцию
        RefuelingStation lucoil = new RefuelingStation();

        System.out.println("\nЗаедем на заправку и заправимся");
        lambo.setRefuelingStation(lucoil);
        lambo.fuel();

        // Создадим станцию техобслуживания
        ServiceStation universalStation = new ServiceStation();

        System.out.println("\nЗаедем на СТО и приведём автомобиль в порядок");
        lambo.setServiceStation(universalStation);
        lambo.wipe();

        // Создадим грузовик
        Car harvester = new Harvester("Kamaz","SL200", Color.RED );
        System.out.printf("\n%s", harvester);

        System.out.println("\nЗаедем на универсальную СТО, заправимся и приведём автомобиль в порядок\n");
        harvester.setRefuelingStation(universalStation);
        harvester.setServiceStation(universalStation);
        harvester.fuel();
        harvester.wipe();

    }

    public static double calculateMaintenance(Car car){
        if (car.getWheelsCount() == 6){
            return 1500 * 6;
        }
        else {
            return 1000 * 4;
        }
    }

}
