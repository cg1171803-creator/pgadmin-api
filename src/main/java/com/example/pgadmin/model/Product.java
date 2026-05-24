package com.example.pgadmin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")//la tabla de la base de datos
public class Product {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
    private String name;
    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return id + " :: " + name + " :: " + price;
    }
}
