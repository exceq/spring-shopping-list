package com.example.shoppinglist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Purchase implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private String description;
    private Date creationDate;
    private Boolean isBought = false;

    public Purchase() {
    }

    public Purchase(Long id, String text, String description, Date creationDate) {
        this.id = id;
        this.text = text;
        this.description = description;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Boolean getBought() {
        return isBought;
    }

    public void setBought(Boolean bought) {
        isBought = bought;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
