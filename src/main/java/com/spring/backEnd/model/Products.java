package com.spring.backEnd.model;

import jakarta.persistence.*;

@Entity
public class Products {
	@Column (name="product_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Column (name="product_name")
	private String productName;
	@Column (name="quantity")
	private Integer quantity;
	@Column (name="price")
	private Integer price;
	@Column (name="image")
	private String image;
	
	
	public Long getProductId () {
		return productId;
	}
	
	public void setProductId (Long productId) {
		this.productId = productId;
	}
	
	public String getProductName () {
		return productName;
	}
	
	public void setProductName (String productName) {
		this.productName = productName;
	}
	
	public Integer getQuantity ()
	{
		return quantity;
	}
	
	public void setQuantity (Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getPrice () {
		return price;
	}
	
	public void setPrice (Integer price) {
		this.price = price;
	}
	
	public String getImage () {
		return image;
	}
	
	public void setImage (String image) {
		this.image = image;
	}
}
