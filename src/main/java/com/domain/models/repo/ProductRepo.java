package com.domain.models.repo;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entities.Product;


public interface ProductRepo extends CrudRepository<Product, Long>{
    
}