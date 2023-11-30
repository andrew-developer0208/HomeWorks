package ru.geekbrains.lesson6.srp2.presenter;

public class OrderPresenter {
    private final Model order;
    private final View view;

    public OrderPresenter(Model order, View view) {
        this.order = order;
        this.view = view;
    }

    /**
     * Load order from console
     */
    public void inputOrder() {
        view.inputFromConsole(order);
    }

    public void saveToJson() {
        view.saveToJson(order);
    }
}
