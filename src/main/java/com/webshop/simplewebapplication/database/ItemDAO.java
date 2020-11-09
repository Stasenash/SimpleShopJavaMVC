package com.webshop.simplewebapplication.database;

import com.webshop.simplewebapplication.model.Item;

import java.util.List;


public interface ItemDAO {
    void addItem(Item item);
    List<Item> findAll();
    Item findById(int id);
    void deleteItem(int id);
    int countOfItems();
    List<Item> findAllInCart();
    void addItemToCart(int id);
    void deleteFromCart(int id);
}
