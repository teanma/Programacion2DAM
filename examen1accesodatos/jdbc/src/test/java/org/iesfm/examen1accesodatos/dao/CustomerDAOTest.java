package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.BankConfiguration;
import org.iesfm.examen1accesodatos.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BankConfiguration.class})
public class CustomerDAOTest {
    @Autowired
    private CustomerDAO customerDAO;

    @Test
    public void listTest(){
        List<Customer> customers = customerDAO.list("ES00000000");
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }

    @Test
    public void insertTest(){

        customerDAO.insert(new Customer( 3, "XXXCCCC", "Dr", "Eggman", 12223));
    }
}