package org.iesfm.examen1accesodatos.dao;

import org.iesfm.examen1accesodatos.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> list (String nif);

    List<Account> listByIBAN (String iban);

    boolean updateAccount (String iban, double balance);
}
