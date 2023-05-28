package com.spring.backEnd.service;


import com.spring.backEnd.model.Products;
import com.spring.backEnd.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
	
	private final ProductsRepository productsRepository;
	
	@Autowired
	public ProductsService (ProductsRepository productsRepository)
	{
		this.productsRepository=productsRepository;
	}
	
	
	public List <Products> getAllProducts()
	{
		return productsRepository.findAll ();
	}
	
	public Products getProductById (Long productId)
	{
		return productsRepository.findById (productId).orElseThrow ();
	}
	public Products getProductByName(String productName)
	{
		return productsRepository.findByProductName (productName);
	}
	
	public void deleteProduct(Long productId)
	{
		productsRepository.deleteById (productId);
	}
	
	public Products saveProduct(Products product)
	{
		return productsRepository.save (product);
	}
	
}
