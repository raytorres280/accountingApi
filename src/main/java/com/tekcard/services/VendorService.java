package com.tekcard.services;

import com.tekcard.dao.VendorRepository;
import com.tekcard.entities.Vendor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Transactional
public class VendorService {

    @Autowired
    private VendorRepository _vendorRepository;

    @Autowired
    DistributorService distributorService;

    public Vendor getVendor(int id) {
        try {
            var vendor = _vendorRepository.findById(id);
            return vendor.orElseThrow();
        } catch (NoSuchElementException ex) {
            throw ex;
        }
    }

    public Iterable<Vendor> getVendors() {
        return _vendorRepository.findAll();
    }

    public Vendor createVendor(Vendor vendor) {
        try {
            return _vendorRepository.save(vendor);
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<Vendor> getVendorsWithStats() {
        var vendors = getVendors();
        for (var vendor: vendors) {
            vendor.totalProfits = getVendorTotalProfits(vendor.id);
            vendor.distributorCount = vendor.distributors.size();
        }
        return vendors;
    }

    public double getVendorTotalProfits(int vendorId) {
        var vendor = _vendorRepository.findById(vendorId).orElseThrow();
        var total = 0;
        for (var distributor: vendor.distributors) {
            total += distributorService.getTotalProfits(distributor.id);
        }
        return total;
    }

}
