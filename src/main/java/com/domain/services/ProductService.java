package com.domain.services;

import jakarta.transaction.Transactional;

import com.domain.models.entities.Product;
import com.domain.models.repo.ProductRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Object findOne(Long id){
        Optional<Product> product  = productRepo.findById(id);
        if (product.isPresent()) {
            return product.get();
        }else{
            return "Data with id " + id + " Not Found";
        }
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public Object removeOne(Long id){
        Optional<Product> optionalList= productRepo.findById(id);

        if (optionalList.isPresent()) {
            productRepo.deleteById(id);
            return "Success Deleted Id " + id;
        }else{
            return "Data with id " + id + " Not Found";
        }
    }
    
    public Object update(Long id, Product updatedProduct){
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updatedProduct.getName()); 
            existingProduct.setDescription(updatedProduct.getDescription()); 
            existingProduct.setPrice(updatedProduct.getPrice()); 
            return productRepo.save(existingProduct);
        } else {
            return "Data with id " + id + " Not Found";
        }
    }

}
