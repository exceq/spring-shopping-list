package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Purchase;
import com.example.shoppinglist.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class PurchasesViewController {
    final PurchaseService purchaseService;

    @Autowired
    public PurchasesViewController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("purchases", purchaseService.listAllPurchases());
        return "list";
    }

    @RequestMapping(path = "/items/{id}", method = RequestMethod.GET)
    public String single(@PathVariable("id") Long id, Model model) {
        Optional<Purchase> purchase = purchaseService.getPurchase(id);
        if (purchase.isPresent()) {
            model.addAttribute("item", purchase.get());
            return "single";
        } else {
            return "redirect:/error404";
        }
    }

}
