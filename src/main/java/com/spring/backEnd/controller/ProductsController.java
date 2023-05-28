package com.spring.backEnd.controller;

import com.spring.backEnd.model.Products;
import com.spring.backEnd.repository.ProductsRepository;
import com.spring.backEnd.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductsController
{
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	
	
	@PostMapping("/saveProduct")
	public Products saveProduct(@RequestParam("productName") String productName,
	                            @RequestParam("quantity") int quantity,
	                            @RequestParam("price") int price,
	                            @RequestParam("image") MultipartFile imageFile) throws IOException {
		
		String fileName = StringUtils.cleanPath (imageFile.getOriginalFilename ());
		
		//locate the copy folder to react folder product
		String filePath = "/home/bas200180/Desktop/frontend/public/product/" + fileName;
		
		// Save the file to the desired location
		File destFile = new File(filePath);
		imageFile.transferTo(destFile);
		
		System.out.println (filePath);
		Products product = new Products();
		product.setProductName (productName);
		product.setQuantity(quantity);
		product.setPrice(price);
		product.setImage (fileName);
		
		return productsService.saveProduct (product);
	}
	
	
	@GetMapping("/getAllProducts")
	List<Products> getAllProducts ()
	{
		return productsService.getAllProducts ();
	}
	
	@GetMapping("/getProductById/{productId}")
	Products getProductById(@PathVariable Long productId)
	{
		return productsService.getProductById (productId);
	}
	
	@PutMapping("/updateProduct/{productId}")
Products updateProduct(@RequestBody Products saveProduct,
	                   @PathVariable Long productId)
	{
		return productsRepository.findById (productId).map(Products ->
		{
			
			
			Products.setProductName (saveProduct.getProductName ());
			Products.setQuantity (saveProduct.getQuantity ());
			Products.setPrice (saveProduct.getPrice ());
			return productsRepository.save (Products);

		}
		).orElseThrow ();
	}
	
	@DeleteMapping("deleteProduct/{productId}")
	String deleteUser(@PathVariable Long productId)
	{
		productsService.deleteProduct (productId);
		return "Product With Id "+productId+" Has Deleted Successfully";
	}
	
	@GetMapping("/getProductByName/{productName}")
	Products getProductByName(@PathVariable String productName)
	{
	return productsService.getProductByName (productName);
	}
	
	
}
