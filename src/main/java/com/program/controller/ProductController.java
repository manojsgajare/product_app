package com.program.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.entity.Product;

import com.program.exception.ProductException;
import com.program.repository.productDao;
import com.program.service.ProductService;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

	
	@Autowired
	public ProductService productservice;
	
	@Autowired
	public productDao productdao;
	
	// BACKEND
	
		// Get All Products
		
		@GetMapping("/allproducts")
		public ResponseEntity<List<Product>> getAllProduct() throws ProductException 
		{
			List<Product> product =	productservice.getAllProduct();
			return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
		}
		
		@PostMapping("/products")
		public ResponseEntity<Product> addNewProduct (@RequestBody Product product, Model m) throws ProductException
		{
			Product product1 = productservice.addNewProduct(product);
			System.out.println(product);
			return new ResponseEntity<Product>(product1, HttpStatus.OK);	
		}
		
		@GetMapping("/products/getById/{Id}")
		public ResponseEntity<Product> getProudctById(@PathVariable ("Id") Integer id ) throws ProductException{
			Product product1=productservice.getProudctById(id);
			return new ResponseEntity<Product>(product1,HttpStatus.OK);
		}
		
		@PutMapping("/products/update/{id}")
		public ResponseEntity<Product> updateProductById(@PathVariable("Id") Integer id) throws ProductException{
			Product product1=	productservice.updateProductById(id);

			return new ResponseEntity<Product>(product1,HttpStatus.OK);
		}
		
		@DeleteMapping("/products/delete/{Id}")
		public ResponseEntity<Product> deleteProductById(@PathVariable ("Id") Integer id ) throws ProductException{
			Product product1=productservice.deleteProductById(id);
			return new ResponseEntity<Product>(product1,HttpStatus.OK);
		}
	
	// FRONTEND
	
}




