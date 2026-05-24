package com.example.pgadmin.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pgadmin.model.Product;
import com.example.pgadmin.service.ProductService;;

@RestController
@RequestMapping("product")//de la base de datos
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductController {

    @Autowired
	private ProductService service;

	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> getById(@PathVariable Integer id) {
		Product product = service.getById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping
	public void registrar(@RequestBody Product product) {
		service.save(product);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			Product auxProduct = service.getById(id);
			product.setId(auxProduct.getId());
			service.save(product);
			return new ResponseEntity<String>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("product not found xd", HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
    
}
