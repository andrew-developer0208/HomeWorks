package ru.geekbrains.lesson6.srp2.presenter;

public interface Model {
    String getClientName();
    String getProduct();
    int getPrice();
    int getQnt();
    void setClientName(String clientName);
    void setProduct(String product);
    void setQnt(int qnt);
    void setPrice(int price);
}
