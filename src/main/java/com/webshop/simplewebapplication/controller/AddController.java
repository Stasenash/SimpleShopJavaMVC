package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ItemService;
import com.webshop.simplewebapplication.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AddController {

@Autowired
ItemService itemService;

    @PostMapping("/add/confirm")
    public ModelAndView add(@RequestParam("name") String name,
                            @RequestParam("price") int price)  {

        itemService.addItem(new Item(0, name, price, "Доступно для покупки"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addItem");
        return modelAndView;
    }

    @RequestMapping(path = "/add/{id}/cart", method = RequestMethod.POST)
    public void addInCart(@PathVariable("id") int id) {
        itemService.addItemToCart(id);
    }
}
