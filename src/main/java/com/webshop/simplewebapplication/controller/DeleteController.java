package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DeleteController {
    @ResponseBody
    @RequestMapping(path = "/item/{id}/delete", method = RequestMethod.POST)
    public ModelAndView delete(@PathVariable("id") int id) {
        ItemService prSer = new ItemService();
        prSer.deleteItem(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(path = "/item/{id}/delete/cart", method = RequestMethod.POST)
    public ModelAndView deleteFromCart(@PathVariable("id") int id) {
        ItemService prSer = new ItemService();
        prSer.deleteFromCart(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        return modelAndView;
    }

}
