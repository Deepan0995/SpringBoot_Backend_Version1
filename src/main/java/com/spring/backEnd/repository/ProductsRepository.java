package com.spring.backEnd.repository;

import com.spring.backEnd.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long>
{
Products findByProductName(String productName);

}
