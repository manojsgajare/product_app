package com.program.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.program.entity.Product;

import com.program.exception.ProductException;

import com.program.repository.productDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private productDao prdt;
	

	// FRONTEND
	
	
	
	@Override
	public Product register(Product product) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	

	// *************************** // 
	
	// BACKEND
	
	@Override
	public List<Product> getAllProduct() throws ProductException {
		return prdt.findAll();
	}
	
	@Override
	public Product addNewProduct(Product product) throws ProductException 
	{
		Product prd=prdt.save(product);
		
		if(prd != null) {
			return prd;
		}
		else {
			throw new ProductException("Product deatails is Empty...");
		}
	}

	@Override
	public Product getProudctById(Integer PId) throws ProductException {
		Optional<Product> opt= prdt.findById(PId);
		if(opt.isPresent()) {
			Product  existingProduct=opt.get();
			return existingProduct;
		}
		else {
			throw new ProductException("Product does not exist with Id :"+PId);
			
		}
		
	}

	@Override
	public Product updateProductById(Integer id) throws ProductException {
		Optional<Product> opt = prdt.findById(id);
		
		if (opt.isPresent())
		{
			Product p1 = prdt.save(id);
			return p1;
		}else {
	        throw new ProductException("Product with given id is not presesnt..."+ id);

		}
		
	}

	
	
	@Override
	public Product deleteProductById(Integer Id) throws ProductException {
	
		Optional<Product> opt= prdt.findById(Id);
		if(opt.isPresent()) {
			Product  existingProduct=opt.get();
			prdt.delete(existingProduct);
			
			return existingProduct;
		}
		else {
			throw new ProductException("Product does not exist with Id :"+Id);
			
		}
			
	}








	
}
