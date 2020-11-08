package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ItemService;
import com.webshop.simplewebapplication.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListController {

    @GetMapping("/")
    public String index(Model model) {
        ItemService itemService = new ItemService();
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        ItemService itemService = new ItemService();
        List<Item> items = itemService.findAllInCart();
        model.addAttribute("items", items);
        return "cart";
    }
}
