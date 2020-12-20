package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ItemService;
import com.webshop.simplewebapplication.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DeleteController {

    static final Logger logger = LoggerFactory.getLogger(DeleteController.class);

    @RequestMapping(path = "/item/{id}/delete", method = RequestMethod.POST)
    public ModelAndView delete(@PathVariable("id") int id) {
        ItemService itemService = new ItemService();
        itemService.deleteItem(id);
        logger.info("Deleted item with item_id: " + id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(path = "/item/{id}/delete/cart", method = RequestMethod.POST)
    public ModelAndView deleteFromCart(@PathVariable("id") int id) {
        ItemService itemService = new ItemService();
        itemService.deleteFromCart(id, false);
        logger.info("Deleted item from cart with item_id: " + id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @RequestMapping(path = "/items/deleteAll/cart", method = RequestMethod.POST)
    public ModelAndView deleteAllFromCart() {
        ItemService itemService = new ItemService();
        List<Item> items = itemService.findAllInCart();
        for (Item item:items){
            itemService.deleteFromCart(item.getId(), true);
        }
        logger.info("Deleted all items from cart");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        return modelAndView;
    }

}
