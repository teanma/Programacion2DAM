package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.Account;
import org.iesfm.examen1accesodatos.BankConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BankConfiguration.class})
public class AccountDAOTests {

    @Autowired
    private AccountDAO accountDAO;

    @Test
    public void listTest() {
        List<Account> accounts = accountDAO.list("00000000X");
        for (Account account : accounts){
            System.out.println(account.toString());
        }
    }

    @Test
    public void getAccountTest(){
        List<Account> accounts = accountDAO.listByIBAN("ES00000000");
        for (Account account : accounts){
            System.out.println(account.toString());
        }
    }

    @Test
    public void updateTest(){
        accountDAO.updateAccount("ES00000000", 40000);
    }
}
