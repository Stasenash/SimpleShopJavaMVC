package com.webshop.simplewebapplication.database.User;

import com.webshop.simplewebapplication.database.Item.ItemDAO;
import com.webshop.simplewebapplication.model.Cart;
import com.webshop.simplewebapplication.model.MyUser;
import org.springframework.stereotype.Service;

@Service
public class UserDAOHib implements UserDAO {

    @Override
    public MyUser findByLogin(String login) {
    //TODO: вернуть юзера из бд
        return new MyUser(1, "stasenash", "123456", new Cart(1,"stasenash"));
    }
}
