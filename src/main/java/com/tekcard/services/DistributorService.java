package com.tekcard.services;

import com.tekcard.dao.DistributorRepository;
import com.tekcard.entities.Distributor;
import com.tekcard.entities.Sale;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DistributorService {

    @Autowired
    DistributorRepository distributorRepository;


    public Iterable<Distributor> getDistributorsWithStats() {
        var distributors = distributorRepository.findAll();
        for(var distributor: distributors) {
            distributor.totalSalesmen = distributor.salesmen.size();
            distributor.totalProfits = getTotalProfits(distributor.id);
        }
        return distributors;
    }
    public double getTotalProfits(int distributorId) {
        var distributor = distributorRepository.findById(distributorId).orElseThrow();
        var totalProfits = 0 ;
        for (var salesman : distributor.salesmen) {
            for (Sale sale: salesman.sales) {
                var saleProfits = sale.product.price * distributor.profitPercentagePerItem;
                totalProfits += saleProfits;
            }
        }
        return totalProfits;
    }
}
