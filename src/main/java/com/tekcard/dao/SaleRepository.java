package com.tekcard.dao;

import com.tekcard.entities.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Integer> { }