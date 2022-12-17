package com.tekcard.dao;

import com.tekcard.entities.ProductImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> { }
