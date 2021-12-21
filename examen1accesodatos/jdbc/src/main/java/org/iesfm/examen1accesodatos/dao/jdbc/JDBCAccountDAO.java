package org.iesfm.examen1accesodatos.dao.jdbc;

import org.iesfm.examen1accesodatos.Account;
import org.iesfm.examen1accesodatos.dao.AccountDAO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCAccountDAO implements AccountDAO {

    private Account account;

    private static final String SELECT_BY_NIF = "SELECT a.* FROM Account a INNER JOIN " +
            "Customer c ON a.owner_id=c.id " +
            "WHERE c.nif =:nif";

    private static final String SELECT_ACCOUNT_BY_IBAN = "SELECT * FROM Account WHERE iban =:iban";
    private static final String UPDATE_ACCOUNT = "UPDATE Account SET balance = :balance WHERE iban =:iban";

    public JDBCAccountDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Account> list(String nif) {
        Map<String, Object> params = new HashMap<>();
        params.put("nif", nif);
        return jdbc.query(SELECT_BY_NIF, params, (rs, rownum) -> new Account(
                rs.getString("iban"),
                rs.getInt("owner_id"),
                rs.getDouble("balance"),
                rs.getDate("open_date")
        ));

    }

    @Override
    public List<Account> listByIBAN(String iban) {
        Map<String, Object> params = new HashMap<>();
        params.put("iban", iban);
        return jdbc.query(SELECT_ACCOUNT_BY_IBAN, params, (rs, rowNum) -> new Account(
                rs.getString("iban"),
                rs.getInt("owner_id"),
                rs.getDouble("balance"),
                rs.getDate("open_Date")
        ));
    }

    @Override
    public boolean updateAccount(String iban, double balance) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("iban", iban);
            params.put("balance", balance);

            return jdbc.update(UPDATE_ACCOUNT, params) == 1;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }
}
