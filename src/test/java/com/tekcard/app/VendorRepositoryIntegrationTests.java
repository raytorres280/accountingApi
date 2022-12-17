package com.tekcard.app;

import com.tekcard.dao.VendorRepository;
import com.tekcard.entities.Vendor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.Optional;

//@SpringBootTest
@SpringBootTest
//@AutoConfigureTestDatabase
public class VendorRepositoryIntegrationTests {

    @Bean
    public DataSource dataSource() {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:./db/accounting.sqlite");
        return dataSource;
    }

    @Autowired
    VendorRepository repository;


//    @BeforeEach
//    void setup() {
//
//    }

    @Test
    void findByIdReturnsVendor() {
        repository.save(new Vendor());
        Optional<Vendor> maybeVendor = repository.findById(1);
        Assert.isTrue(maybeVendor.isPresent(), "true");
    }

}
