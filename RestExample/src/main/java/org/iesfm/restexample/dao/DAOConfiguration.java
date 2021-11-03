package org.iesfm.restexample.dao;

import org.iesfm.restexample.dao.inmemory.InMemoryDepartmentDAO;
import org.iesfm.restexample.dao.jdbc.JDBCDepartmentDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DAOConfiguration {

    @Bean
    public DepartmentDAO departmentDAO(NamedParameterJdbcTemplate jdbc) {
        return new JDBCDepartmentDAO(jdbc) {
        };
    }
}
