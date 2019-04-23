package com.bespin.bcustomer;

import com.bespin.bcustomer.service.BcustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BcustomerApplication.class)
public class BcustomerApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BcustomerService bcustomerService;

    @Test
    public void contextLoads() {
        System.out.println(bcustomerService.findAll().size());
    }
}
