package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Purchase;
import com.example.shoppinglist.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseService {
// TODO

    final PurchaseRepository postRepository;

    @Autowired
    public PurchaseService(PurchaseRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Iterable<Purchase> listAllPurchases() {
        return postRepository.findAll();
    }

    public Optional<Purchase> getPurchase(long id){
        return postRepository.findById(id);
    }

    public void create(String text) {
        Purchase purchase = new Purchase(null, text, new Date());
        postRepository.save(purchase);
    }
}