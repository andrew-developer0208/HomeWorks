package ru.geekbrains.architecture.lesson4.task2;

import java.util.Date;

class Ticket{

    static int counter = 4000;
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    //region Constructors

    public Ticket(){
        id = ++counter;
    }

    //endregion


    public boolean isEnable() {
        return enable;
    }

    //region Setters

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    //endregion

    //region Getters

    public int getId() {
        return id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    //endregion
}
