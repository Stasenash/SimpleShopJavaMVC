package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private CustomUserDetailsService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView add(@RequestParam("login") String login,
                            @RequestParam("password") String password)  {

//       userService.addUser();
//        если успешно то создаем корзину и кидаем на логин
//        иначе пишем ошибку
        logger.info("Created user with login: " + login);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
