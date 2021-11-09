package org.iesfm.restexample.dao;

import org.iesfm.restexample.Employee;
import org.iesfm.restexample.controller.DepartmentController;
import org.iesfm.restexample.controller.EmployeeController;
import org.iesfm.restexample.dao.inmemory.InMemoryDepartmentDAO;
import org.iesfm.restexample.dao.inmemory.InMemoryEmployeeDAO;
import org.iesfm.restexample.dao.jdbc.JDBCDepartmentDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class DAOConfiguration {

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DepartmentDAO departmentDAO(NamedParameterJdbcTemplate jdbc) {
        return new JDBCDepartmentDAO(jdbc) {
        };
    }

    @Bean
    public InMemoryEmployeeDAO inMemoryEmployeeDAO() {
        return new InMemoryEmployeeDAO();
    }

    @Bean
    public DataSource dataSource(
            @Value("${database.url}") String url,
            @Value("${database.user}") String user,
            @Value("${database.password}") String password
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
