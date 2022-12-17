package com.tekcard.controllers;

import com.tekcard.entities.Distributor;
import com.tekcard.services.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distributors")
public class DistributorController {

    @Autowired
    DistributorService distributorService;

    @GetMapping(value = "/{id}/totalProfits", produces = "application/json")
    public double getTotalProfits(@PathVariable int id) {
        return distributorService.getTotalProfits(id);
    }

    @GetMapping(value = "/stats")
    public Iterable<Distributor> getDistributorsWithStats() {
        return distributorService.getDistributorsWithStats();
    }

}
