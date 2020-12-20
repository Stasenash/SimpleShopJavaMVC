package com.webshop.simplewebapplication.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    public CartItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Cart cart;

    public CartItem(Item item, Cart cart) {
        this.item = item;
        this.cart = cart;
    }
}