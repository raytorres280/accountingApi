package com.tekcard.dao;

import com.tekcard.entities.Salesman;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesmanRepository extends CrudRepository<Salesman, Integer> { }
