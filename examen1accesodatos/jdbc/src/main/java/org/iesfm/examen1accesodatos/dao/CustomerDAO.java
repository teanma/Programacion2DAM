package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> list(String iban);

    boolean insert(Customer customer);
}
