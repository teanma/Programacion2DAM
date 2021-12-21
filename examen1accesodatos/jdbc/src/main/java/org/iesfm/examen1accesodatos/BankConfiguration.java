package org.iesfm.examen1accesodatos;

import org.iesfm.examen1accesodatos.dao.AccountDAO;
import org.iesfm.examen1accesodatos.dao.CustomerDAO;
import org.iesfm.examen1accesodatos.dao.MovementDAO;
import org.iesfm.examen1accesodatos.dao.jdbc.JDBCAccountDAO;
import org.iesfm.examen1accesodatos.dao.jdbc.JDBCCustomerDAO;
import org.iesfm.examen1accesodatos.dao.jdbc.JDBCMovementDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration
@PropertySource("applications.properties")
public class BankConfiguration {

    @Bean
    public NamedParameterJdbcTemplate jdbc(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public MovementDAO movementDAO (NamedParameterJdbcTemplate jdbc){
        return new JDBCMovementDAO(jdbc);
    }

    @Bean
    public CustomerDAO customerDAO(NamedParameterJdbcTemplate jdbc) {
        return new JDBCCustomerDAO(jdbc);
    }

    @Bean
    public AccountDAO accountDAO(NamedParameterJdbcTemplate jdbc) {
        return new JDBCAccountDAO(jdbc);
    }

    @Bean
    public DataSource mysqlDataSource(
            @Value("${database.url}") String url,
            @Value("${database.user}") String user,
            @Value("${database.password}") String password
    ) {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setUrl(url);
        driverManager.setUsername(user);
        driverManager.setPassword(password);

        return driverManager;
    }

}
