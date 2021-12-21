package org.iesfm.examen1accesodatos.dao.jdbc;

import org.iesfm.examen1accesodatos.Customer;
import org.iesfm.examen1accesodatos.dao.CustomerDAO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCustomerDAO implements CustomerDAO {

    private static final String SELECT_BY_IBAN = "SELECT c.* FROM Account a INNER JOIN " +
            "Customer c ON a.owner_id=c.id " +
            "WHERE iban = :iban";

    private static final String INSERT_CUSTOMER = "INSERT INTO Customer " +
            "(id, " +
            "nif, " +
            "name, " +
            "surname, " +
            "cp) " +
            " VALUES ( " +
            ":id, " +
            ":nif, " +
            ":name, " +
            ":surname, " +
            ":cp)";

    private NamedParameterJdbcTemplate jdbc;

    public JDBCCustomerDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Customer> list(String iban) {
        Map<String, Object> params = new HashMap<>();
        params.put("iban", iban);
        return jdbc.query(SELECT_BY_IBAN, params, (rs, rowNum) -> new Customer(
                        rs.getInt("id"),
                        rs.getString("nif"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("cp")
                )
        );
    }

    @Override
    public boolean insert(Customer customer) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("id", customer.getId());
            params.put("nif", customer.getNif());
            params.put("name", customer.getName());
            params.put("surname", customer.getSurname());
            params.put("cp", customer.getCp());
            return jdbc.update(INSERT_CUSTOMER, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }

    }
}
