package ru.geekbrains.lesson6.srp2.model;

import ru.geekbrains.lesson6.srp2.presenter.Model;

public class OrderModel implements Model {
    private String clientName;
    private String product;
    private int qnt;
    private int price;

    @Override
    public String getClientName() {
        return this.clientName;
    }

    @Override
    public String getProduct() {
        return this.product;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getQnt() {
        return this.qnt;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
