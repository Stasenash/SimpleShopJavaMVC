package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ItemService;
import com.webshop.simplewebapplication.model.Item;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class ListController {

    @GetMapping("/")
    public ModelAndView index() {
        ItemService itemService = new ItemService();
        List<Item> items = itemService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("items", items);
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView cart() {
        ItemService itemService = new ItemService();
        List<Item> items = itemService.findAllInCart();
        int sumInCart = itemService.getSumInCart();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        modelAndView.addObject("items", items);
        modelAndView.addObject("sum",sumInCart);
        return modelAndView;
    }
}
