package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ItemService;
import com.webshop.simplewebapplication.model.Category;
import com.webshop.simplewebapplication.model.Item;
import com.webshop.simplewebapplication.model.MyUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class AddController {

    @Autowired
    ItemService itemService;

    static final Logger logger = LoggerFactory.getLogger(AddController.class);

    @PostMapping("/add")
    public ModelAndView add(@RequestParam("name") String name,
                            @RequestParam("price") int price,
                            @RequestParam("category") String category)  {
//        TODO: отправить туда где нужен каррент юзер
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

//        TODO: поиск по строке категории
        itemService.addItem(new Item(0, name, price, "89634609874", new Category(0, "Продукты"), new MyUser()));
        logger.info("Added item with name: " + name + ", price " + price + ", category " + category + " by user: " + currentUserName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addItem");
//        TODO: категории из БД
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Meals"));
        categories.add(new Category(0, "Electronics"));

        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @RequestMapping(path = "/add/{id}/cart", method = RequestMethod.POST)
    public void addInCart(@PathVariable("id") int id) {
        itemService.addItemToCart(id);
        logger.info("Added item to cart with item_id: " + id);
    }
}
