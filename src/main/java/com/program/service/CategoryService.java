package com.program.service;

import java.util.List;

import com.program.entity.Category;
import com.program.entity.Product;
import com.program.exception.CategoryException;
import com.program.exception.ProductException;

public interface CategoryService {
	
	
	
	
	//FRONTEND
	
	//public Category register(Category category) throws CategoryException;
	
	
	
	
	// BACKEND

	public List<Category>  getAllCategories() throws CategoryException;
	
	 public Category addNewCategory(Category category)throws CategoryException;
	 public Category getCategoryById(Integer CId)throws CategoryException;
	 public Category updateCategoryById(Category category) throws CategoryException;
	 public Category deleteCategoryById(Integer CId) throws CategoryException;

	 
}
