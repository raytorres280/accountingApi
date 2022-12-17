package com.tekcard.services;

import com.tekcard.dao.SalesmanRepository;
import com.tekcard.entities.Salesman;
import org.springframework.beans.factory.annotation.Autowired;

public class SalesmanService {
    @Autowired
    SalesmanRepository salesmanRepository;

    public Salesman getSalesman(int id) {
        return salesmanRepository.findById(id).orElseThrow();
    }
}
