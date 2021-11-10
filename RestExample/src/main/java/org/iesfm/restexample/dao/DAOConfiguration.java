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
public class DAOConfiguration {

    @Bean
    public DepartmentDAO departmentDAO() {
        return new InMemoryDepartmentDAO() {
        };
    }

    @Bean
    public EmployeeDAO employeeDAO() {
        return new InMemoryEmployeeDAO();
    }

}
