package com.tekcard.controllers;

import com.tekcard.entities.Vendor;
import com.tekcard.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    VendorService _vendorService;
    @GetMapping(value = "/{id}", produces = "application/json")
    public Vendor getVendor(@PathVariable int id) {
        System.out.println("id = " + id);
        return _vendorService.getVendor(id);
    }

    @GetMapping(value = "/stats")
    public Iterable<Vendor> getVendorsWithStats() {
        return _vendorService.getVendorsWithStats();
    }

    @PostMapping(value = "", produces = "application/json")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        System.out.println("creating vendor with null id: " + vendor.id);
        return _vendorService.createVendor(vendor);
    }
}
