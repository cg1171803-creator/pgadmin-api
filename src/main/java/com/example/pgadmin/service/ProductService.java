package com.example.pgadmin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pgadmin.model.Product;
import com.example.pgadmin.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    @Autowired
	private ProductRepository repo;

	public List<Product> getAll() {
		return repo.findAll();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product getById(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer controlNumber) {
		repo.deleteById(controlNumber);
	}
}
