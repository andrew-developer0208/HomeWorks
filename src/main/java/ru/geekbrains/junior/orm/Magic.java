package ru.geekbrains.junior.orm;

import javax.persistence.*;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Table;

@Entity
@Table(name = "test.magic")
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "название")
    private String name;

    @Column(name = "повреждение")
    private int damage;

    @Column(name = "атака")
    private int attBonus;

    public Magic() {
    }

    public Magic(String name, int damage, int attBonus) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttBonus() {
        return attBonus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttBonus(int attBonus) {
        this.attBonus = attBonus;
    }
}
