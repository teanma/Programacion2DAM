package org.iesfm.instituto.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class InstitutoConfiguration {

    @Bean
    public InsertTitleProgram insertTitleProgram(NamedParameterJdbcTemplate jdbc) {
        return new InsertTitleProgram(jdbc);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:13306/Instituto");
        dataSource.setUsername("root");
        dataSource.setPassword("federica");
        return dataSource;
    }
}
