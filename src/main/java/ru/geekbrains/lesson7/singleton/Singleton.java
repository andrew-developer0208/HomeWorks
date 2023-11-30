package ru.geekbrains.lesson7.singleton;

public class Singleton {

    private static Singleton instance;

    private String param1;
    private  int param2;

    //region getters

    public String getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    //endregion


    //region setters

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    //endregion

    /**
     * Constructor
     */
    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return  instance;
    }
}
