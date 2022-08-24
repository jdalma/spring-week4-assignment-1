package com.codesoom.assignment.controller;

import com.codesoom.assignment.dto.ProductDTO;
import com.codesoom.assignment.exception.ResourceNotFoundException;
import com.codesoom.assignment.service.ProductService;
import com.codesoom.assignment.domain.Product;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> findAllProduct(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public Product findProduct(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        return service.save(productDTO.toProduct());
    }

    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product){
        return service.update(id , product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteById(id);
    }
}
