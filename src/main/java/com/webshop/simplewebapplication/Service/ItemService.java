package com.webshop.simplewebapplication.Service;

import com.webshop.simplewebapplication.database.ItemDAO;
import com.webshop.simplewebapplication.database.ItemDAOHib;
import com.webshop.simplewebapplication.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
//    @Autowired
    private static ItemDAO dataBase = new ItemDAOHib();

    public void addItem(int id, String name, int price, String status) {
        Item item = new Item(id, name, price, status);
        dataBase.addItem(item);
    }

    public void addItemToCart(int id) {
        Item item = findById(id);
        item.setStatus("In cart");
    }

    public List<Item> findAll() {
        return dataBase.findAll();
    }


    public Item findById(int id) {
        return dataBase.findById(id);
    }

    public int countOfItems(){
        return dataBase.countOfItems();
    }

    public void deleteFromCart(int id){
        Item item = findById(id);
        item.setStatus("Is available");
    }


    public void deleteItem(int id) {
        dataBase.deleteItem(id);
    }

    public List<Item> findAllInCart(){
        return dataBase.findAllInCart();
    }
}
