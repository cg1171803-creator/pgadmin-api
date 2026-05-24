package com.example.pgadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pgadmin.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{//cambiar el nombre
    
}

