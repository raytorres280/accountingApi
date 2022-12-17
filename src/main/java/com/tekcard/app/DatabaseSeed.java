package com.tekcard.app;

import com.tekcard.dao.*;
import com.tekcard.entities.Distributor;
import com.tekcard.entities.Sale;
import com.tekcard.entities.Salesman;
import com.tekcard.entities.Vendor;
import com.tekcard.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class DatabaseSeed {

    @Value("${spring.thymeleaf.prefix}")
    private String prefix;
    @Autowired DistributorRepository distributorRepository;
//    @Autowired ProductImageRepository productImageRepository;
//    @Autowired ProductRepository productRepository;
    @Autowired SaleRepository saleRepository;
    @Autowired SalesmanRepository salesmanRepository;
    @Autowired VendorRepository vendorRepository;

    @Autowired
    ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    private void seed() {
        if(vendorRepository.count() == 0) {
            loadVendors();
        }

        if(distributorRepository.count() == 0) {
            loadDistributors();
        }
        if(salesmanRepository.count() == 0) {
            loadSalesmen();
        }

        loadLatestProducts();

        if(saleRepository.count() == 0) {
            try {
                loadSales();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void loadSales() {
        var sales = new ArrayList<Sale>();
        for (int i = 0; i < 100; i++) {
            var productId = new Random().nextInt(1, 31);
            var salesmanId = new Random().nextInt(1, 6);
            var product = productRepository.findById(productId);
            var salesman = salesmanRepository.findById(salesmanId);

            var sale = new Sale();
            sale.product = product.orElseThrow();
            sale.seller = salesman.orElseThrow();
            sales.add(sale);
        }
        saleRepository.saveAll(sales);

    }

    private void loadSalesmen() {
        var distributor1 = distributorRepository.findById(1).orElseThrow();
        var distributor2 = distributorRepository.findById(2).orElseThrow();
        var salesman1 = new Salesman();
        salesman1.name = "john";
        salesman1.distributor = distributor1;

        var salesman2 = new Salesman();
        salesman2.name = "john";
        salesman2.distributor = distributor1;

        var salesman3 = new Salesman();
        salesman3.name = "john";
        salesman3.distributor = distributor2;

        var salesman4 = new Salesman();
        salesman4.name = "john";
        salesman4.distributor = distributor2;

        var salesman5 = new Salesman();
        salesman5.name = "john";
        salesman5.distributor = distributor2;

        var salesmen = new ArrayList<Salesman>();
        salesmen.add(salesman1);
        salesmen.add(salesman2);
        salesmen.add(salesman3);
        salesmen.add(salesman4);
        salesmen.add(salesman5);

        salesmanRepository.saveAll(salesmen);
    }

    private void loadDistributors() {
        var distributor1 = new Distributor();
        distributor1.name = "SellerA";
        distributor1.profitPercentagePerItem = 0.20;
        var distributor2 = new Distributor();
        distributor2.name = "SellerB";
        distributor2.profitPercentagePerItem = 0.30;
        distributorRepository.save(distributor1);
        distributorRepository.save(distributor2);
    }

    private void loadVendors() {
        var vendor = new Vendor();
        vendor.name = "vendorXYZ";
        vendorRepository.save(vendor);
    }

    private void loadLatestProducts() {
        productService.loadRemoteProductsToStorage();
    }
}
