package com.tekcard.services;

import com.tekcard.app.ProductApiClient;
import com.tekcard.dao.ProductRepository;
import com.tekcard.entities.Product;
import jakarta.transaction.Transactional;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    VendorService vendorService;

    public Product getProduct() throws NotImplementedException {
        throw new NotImplementedException("TODO");
    }

//    @Transactional
    @Transactional
    public void loadRemoteProductsToStorage() {
        ProductApiClient client = new ProductApiClient();
        try {
            var response = client.getProducts();
            var vendor = vendorService.getVendor(1);
            for (Product product : response.products) {
                product.vendor = vendor;
//                productRepository.save(product);
            }
            productRepository.saveAll(Arrays.asList(response.products));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}