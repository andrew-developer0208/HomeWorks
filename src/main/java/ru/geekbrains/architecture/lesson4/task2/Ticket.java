package ru.geekbrains.architecture.lesson4.task2;

import java.util.Date;

class Ticket{

    //region Fields

    static int counter = 4000;
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    //endregion

    //region Constructors

    public Ticket(){
        id = ++counter;
        date = new Date();

    }

    //endregion



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

    public boolean isEnable() {
        return enable;
    }

    //endregion


    //region Setters

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    //endregion


    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("ticketID: %d  customerID: %d  QRcode: %s  date: %s", id, customerId, qrcode, date);
    }
}
