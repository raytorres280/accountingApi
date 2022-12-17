package com.tekcard.dao;

import com.tekcard.entities.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Integer> { }
