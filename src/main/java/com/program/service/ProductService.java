package com.program.service;

import java.util.List;

import com.program.entity.Product;

import com.program.exception.ProductException;


public interface ProductService {

	
	// FrontEnd
	
	public Product register(Product product) throws ProductException;
	

//	public void save(Product product);
//	
//	public User register(User user) throws userException;
//	
	
	
	
	
	
	
	
	// Backend API Methods Sevices
	
	 public List<Product>  getAllProduct() throws ProductException;
	 public Product addNewProduct(Product product)throws ProductException;
	 
	 // Edit product by id
	 public Product getProudctById(Integer PId)throws ProductException;
	 public Product updateProductById(Integer id) throws ProductException;
	 public Product deleteProductById(Integer Id) throws ProductException;









	 
	 
	 //public List<Product> home();
	 
	//Product deleteProduct(Integer Id) throws ProductException;
	//public Product getProduct(Integer id);
}
