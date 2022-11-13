package com.program.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.program.entity.Category;
import com.program.entity.Product;
import com.program.exception.CategoryException;
import com.program.repository.categoryDao;
import com.program.repository.productDao;

@Service
public class  CategoryServiceImpl implements CategoryService {

	@Autowired
	private categoryDao crdt;
	
	
	// BACKEND
	
	@Override
	public List<Category> getAllCategories() throws CategoryException {
		return crdt.findAll();
	}

	@Override
	public Category addNewCategory(Category category) throws CategoryException {
		

		
		List<Product> product= category.getProducts();
		
		if(!product.isEmpty()) {
			for(Product p:product) {
				p.setCategory(category);
			}
		}
		Category addCategory= crdt.save(category);
		
		if(addCategory != null) {
			return addCategory;
		}
		else {
			throw new CategoryException("Product details is Empty...");
		}
		
		}
	
	@Override
	public Category updateCategoryById(Category category) throws CategoryException {
		
			Optional<Category> opt = crdt.findById(category.getCategoryId());
			
			if (opt.isPresent())
			{
				Category c1 = crdt.save(category);
				return c1;
			}else {
		        throw new CategoryException("Category with given id is not presesnt........");

			}
	}

	@Override
	public Category getCategoryById(Integer CId) throws CategoryException {
		Optional<Category> opt= crdt.findById(CId);
		if(opt.isPresent()) {
			Category  existingCategory=opt.get();
			return existingCategory;
		}
		else {
			throw new CategoryException("Category does not exist with Id :"+CId);
			
		}
	}
	

	@Override
	public Category deleteCategoryById(Integer CId) throws CategoryException {
		
			Optional<Category> opt= crdt.findById(CId);
			if(opt.isPresent()) {
				Category existingCategory =opt.get();
				crdt.delete(existingCategory);
				
				return existingCategory;
			}
			else {
				throw new CategoryException("Category does not exist with Id :"+CId);
				
			}
	}
	
}

	
	

