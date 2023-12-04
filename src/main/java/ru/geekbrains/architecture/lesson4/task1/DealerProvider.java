package ru.geekbrains.architecture.lesson4.task1;

public class DealerProvider {

    private final Factory factoryProvider;

    public DealerProvider(Factory factoryProvider){
        this.factoryProvider = factoryProvider;
    }

    public ComponentInfo getComponent(int id){




        if (id < 0 || String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали.");
        return factoryProvider.getComponentInfo(id);
    }


}
