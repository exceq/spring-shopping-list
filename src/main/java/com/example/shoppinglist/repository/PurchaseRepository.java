package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}