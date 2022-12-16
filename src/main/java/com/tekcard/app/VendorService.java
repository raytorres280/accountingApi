package com.tekcard.app;

import com.tekcard.dao.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendorService {

    @Autowired
    private VendorRepository _vendorRepository;

    public Vendor getVendor(int id) {
        try {
            Vendor vendor = _vendorRepository.getById(id);
            return vendor;
        } catch (Exception e) {
            throw e;
        }
    }

    public Vendor createVendor(Vendor vendor) {
        try {
            Vendor result = _vendorRepository.save(vendor);
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

}
