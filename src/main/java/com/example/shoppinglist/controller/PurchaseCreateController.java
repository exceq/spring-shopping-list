package com.example.shoppinglist.controller;

import com.example.shoppinglist.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    @RequestMapping(path = "/items/new", method = RequestMethod.GET)
    public String create(Model model) {
        return "create";
    }

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    private String doCreate(@ModelAttribute("text") String text,
                            @ModelAttribute("description") String description) {
        purchaseService.create(text,description);
        return "redirect:/items";
    }
}
