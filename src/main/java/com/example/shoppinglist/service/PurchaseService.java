package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Purchase;
import com.example.shoppinglist.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseService {

    final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Iterable<Purchase> listAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> getPurchase(long id){
        return purchaseRepository.findById(id);
    }

    public void delete(Long id){
        purchaseRepository.deleteById(id);
    }

    public void update(Purchase purchase){
        purchaseRepository.save(purchase);
    }

    public void create(String text, String description) {
        Purchase purchase = new Purchase(null, text, description, new Date());
        purchaseRepository.save(purchase);
    }
}
