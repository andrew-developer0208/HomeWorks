package ru.geekbrains.architecture.lesson3;

import ru.geekbrains.architecture.lesson3.CarType;
import ru.geekbrains.architecture.lesson3.FuelType;
import ru.geekbrains.architecture.lesson3.GearboxType;
import ru.geekbrains.architecture.lesson3.Refueling;

import java.awt.*;

/**
 * 1. Спроектировать абстрактный класс «Car» у которого должны
 * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
 * топлива, тип коробки передач, объём двигателя; методы:
 * движение, обслуживание, переключение передач, включение
 * фар, включение дворников.
 *
 * 2. Создать конкретный автомобиль путём наследования класса
 * «Car».
 *
 * 3. Расширить абстрактный класс «Car», добавить метод: подметать
 * улицу. Создать конкретный автомобиль путём наследования
 * класса «Car». Провести проверку принципа SRP.
 *
 * 4. Расширить абстрактный класс «Car», добавить метод:
 * включение противотуманных фар, перевозка груза. Провести
 * проверку принципа OCP.
 *
 * 5. Создать конкретный автомобиль путём наследования класса
 * «Car», определить число колёс = 3. Провести проверку принципа LSP.
 *
 * 6. Создать интерфейс «Заправочная станция», создать метод:
 * заправка топливом.
 *
 * 7. Имплементировать метод интерфейса «Заправочная станция» в
 * конкретный класс «Car».
 *
 * 8. Добавить в интерфейс «Заправочная станция» методы: протирка
 * лобового стекла, протирка фар, протирка зеркал.
 *
 * 9. Имплементировать все методы интерфейса «Заправочная
 *      * станция» в конкретный класс «Car». Провести проверку
 *      * принципа ISP. Создать дополнительный/е интерфейсы и
 *      * имплементировать их в конкретный класс «Car». Провести
 *      * проверку принципа ISP.
 *
 * 10. Создать путём наследования класса «Car» два
 *      * автомобиля: с бензиновым и дизельным двигателями,
 *      * имплементировать метод «Заправка топливом» интерфейса
 *      * «Заправочная станция». Реализовать заправку каждого
 *      * автомобиля подходящим топливом. Провести проверку принципа DIP.
 *
 ** TODO: Домашнее задание:
 *      * Доработать приложение, спроектированное на семинаре. Добавить тип, описывающий "автомойку" и "сервисную станцию".
 *      * Продемонстрировать работу получившейся программы,
 *      * создать несколько типов автомобилей,
 *      * загнать каждый автомобиль на заправку, а затем и на автомойку.
 */

public abstract class Car {


    //region Конструкторы

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;

    }

    //endregion

    //region Методы

    /**
     * Установить (заехать на) заправочную станцию
     * @param refuelingStation Заправочная станция, имплементирующая интерфейс Refueling
     */
    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    /**
     * Установить станцию техобслуживания
     * @param serviceStation Станция техобслуживания, имплементирующая интерфейс Wiping
     */
    public void setServiceStation(Wiping serviceStation) {
        this.wiping = serviceStation;
    }

    /**
     * Заправить автомобиль
     */
    public void fuel() {
        if (refueling != null){
            refueling.fuel(fuelType);
        }
    }

    /**
     * Обслужить автомобиль
     */
    public void wipe() {
        wiping.wipHeadlights();
        wiping.wipMirrors();
        wiping.wipWindshield();
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // Движение
    public abstract void movement();
    // Обслуживание
    public abstract void maintenance();
    // Переключение передач
    public abstract boolean gearShifting();
    // Включение фар
    public abstract boolean switchHeadlights();
    // Включение дворников
    public abstract boolean switchWipers();

    // Состояние противотуманных фар
    private boolean fogLights = false;
    public boolean switchFogLights(){
        fogLights = !fogLights;
        return fogLights;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("make: %s  model: %s  type: %s", make, model, this.getClass().getSimpleName());
    }

    //endregion

    //region Поля

    private Refueling refueling;

    private Wiping wiping;

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    protected int wheelsCount = 4;

    // Тип топлива
    protected FuelType fuelType = FuelType.Diesel;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;



    //endregion

}
