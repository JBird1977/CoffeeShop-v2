package com.JasonWestbrook.coffeeshop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ItemsDatabase")
public class Item
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    
    String name;
    String description;
    Integer quantity;
    Double price;
    
    public Item() {}
    
    public Item(String name, String description, Integer quantity, Double price)
    {
        this.name = name;
        this.description=description;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Integer getQuantity()
    {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
    
    public Double getPrice()
    {
        return this.price;
    }
    
    public void setPrice(Double price)
    {
        this.price = price;
    }
}
