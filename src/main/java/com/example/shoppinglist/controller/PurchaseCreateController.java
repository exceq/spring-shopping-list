package com.example.shoppinglist.controller;

import com.example.shoppinglist.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PurchaseCreateController {

    final PurchaseService purchaseService;

    @Autowired
    public PurchaseCreateController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String create(Model model) {
        return "create";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    private void doCreate(Model model) {
        String text = (String) model.getAttribute("text");
        String description = (String) model.getAttribute("description");

        purchaseService.create(text,description);
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String create1(Model model) {
        model.addAttribute("appName", "Моё супер приложение!");
        return "create";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String doCreate(@ModelAttribute("text") String text) {
        postService.create(text);
        return "redirect:/abc";
    }
}
