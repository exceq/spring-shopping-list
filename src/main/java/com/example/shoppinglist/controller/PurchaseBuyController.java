package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Purchase;
import com.example.shoppinglist.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class PurchaseBuyController {

    final PurchaseService purchaseService;

    @Autowired
    public PurchaseBuyController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(path = "/items/{id}/buy", method = RequestMethod.POST)
    private String buy(@PathVariable("id") Long id) {
        Purchase p = purchaseService.getPurchase(id).get();
        p.setBought(!p.getBought());
        purchaseService.update(p);
        return "redirect:/items";
    }
}
