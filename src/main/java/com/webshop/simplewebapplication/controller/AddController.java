package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddController {

    @PostMapping("/add/confirm")
    public String add(@RequestParam("name") String name,
                      @RequestParam("price") int price)  {

        ItemService itemService = new ItemService();
        itemService.addItem(0, name, price, "Is available");
        return "confirm";
    }

    @GetMapping("/add")
    public String add(){
        return "addItem";
    }

    @ResponseBody
    @RequestMapping(path = "/add/{id}/cart", method = RequestMethod.POST)
    public void addInCart(@PathVariable("id") int id) {
        ItemService itemService = new ItemService();
        itemService.addItemToCart(id);
    }
}
