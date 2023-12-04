package ru.geekbrains.architecture.lesson4.task1;

import java.util.ArrayList;

/**
 * Завод по производству деталей
 */
public class FactoryProvider implements Factory {

    private PaymentProvider paymentProvider;

    public FactoryProvider(PaymentProvider paymentProvider){
        this.paymentProvider = paymentProvider;
        for (int i = 0; i < 10; i++){
            components.add(new ComponentInfo(900000 + i, String.format("component description %d", 900000 + i)));
        }
        for (int i = 0; i < 5; i++){
            components.add(new ComponentInfo(1000 + i, String.format("component description %d", 1000 + i)));
        }
    }

    private ArrayList<ComponentInfo> components = new ArrayList<>();



    public ComponentInfo getComponentInfo(int id){

        // Предусловие
        if (id < 0)
            throw new RuntimeException("Некорректный номер детали.");

        if (String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали. Деталь существует, но устарела и более не выпускается.");


        // Выполнение подпрограммы
        ComponentInfo componentInfo = null;
        for (ComponentInfo component : components) {
            if (component.getId() == id){
                componentInfo = component;
            }
        }
        // Инвариант #1
        if (componentInfo == null)
            throw new RuntimeException("Деталь не найдена.");

        double price = paymentProvider.getPrice(id);
        // Инвариант #2
        if (price < 10)
            throw new RuntimeException("Цена детали указана некорректно.");


        componentInfo.setPrice(price);

        // Инвариант #3
        if (componentInfo.getPrice() < 10)
            throw new RuntimeException("Цена детали указана некорректно.");


        // Постусловие
        if (componentInfo == null)
            throw new RuntimeException("Деталь не найдена.");


        return componentInfo;
    }

}
