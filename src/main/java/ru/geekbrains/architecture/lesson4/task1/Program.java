package ru.geekbrains.architecture.lesson4.task1;

public class Program {

    public static void main(String[] args) {
        FactoryProvider factoryProvider = new FactoryProvider(new PaymentProvider());
        DealerProvider dealerProvider = new DealerProvider(factoryProvider);

        ComponentInfo component = dealerProvider.getComponent(900003);
        if (component != null)
            System.out.println(component);
    }

}
