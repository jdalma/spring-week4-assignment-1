package com.codesoom.assignment.repository;

import com.codesoom.assignment.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductJPARepository
        extends CrudRepository<Product, Long> {

}
