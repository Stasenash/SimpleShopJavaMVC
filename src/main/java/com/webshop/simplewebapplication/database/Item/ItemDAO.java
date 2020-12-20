package com.webshop.simplewebapplication.database.Item;

import com.webshop.simplewebapplication.model.Category;
import com.webshop.simplewebapplication.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemDAO {
    void addItem(Item item);
    List<Item> findAll();
    Item findById(int id);
    void deleteItem(int id);
    int countOfItems();
    List<Item> findAllInCart();
    void addItemToCart(int id);
    void deleteFromCart(int id, boolean isSold);
    int getSumInCart();
    List<Item> getAllByCategory(Category category);
}
