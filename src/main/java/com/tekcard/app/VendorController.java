package com.tekcard.app;

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

    @PostMapping(value = "", produces = "application/json")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return _vendorService.createVendor(vendor);
    }
}
