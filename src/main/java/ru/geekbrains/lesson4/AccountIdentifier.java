package ru.geekbrains.lesson4;

public class AccountIdentifier {

    private int id;

    private String add;


    public int getId() {
        return id;
    }

    public String getAdd() {
        return add;
    }

    public AccountIdentifier(int id, String add) {
        this.id = id;
        this.add = add;
    }

    @Override
    public String toString() {
        return "AccountIdentifier{" +
                "id=" + id +
                ", add='" + add + '\'' +
                '}';
    }
}
