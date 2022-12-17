package com.tekcard.dao;

import com.tekcard.entities.Distributor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends CrudRepository<Distributor, Integer> { }
