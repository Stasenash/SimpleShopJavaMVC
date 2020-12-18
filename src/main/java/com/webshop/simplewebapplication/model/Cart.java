package com.webshop.simplewebapplication.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    public Cart(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @ManyToOne
    private Item item;

    public Cart(int id, String name, Item item) {
        this.id = id;
        this.name = name;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ',' +
                '}';
    }
}
