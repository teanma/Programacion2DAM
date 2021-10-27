package org.iesfm.instituto.jdbc.configuration;

import org.iesfm.instituto.jdbc.dao.StudentDAO;
import org.iesfm.instituto.jdbc.dao.TitleDAO;
import org.iesfm.instituto.jdbc.dao.TitleGroupDAO;
import org.iesfm.instituto.jdbc.reader.StudentReader;
import org.iesfm.instituto.jdbc.reader.TitleGroupReader;
import org.iesfm.instituto.jdbc.reader.TitleReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration
@PropertySource("application.properties")
public class InstitutoConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public TitleDAO titleDAO(NamedParameterJdbcTemplate jdbc) {
        return new TitleDAO(jdbc);
    }

    @Bean
    public TitleGroupDAO titleGroupDAO(NamedParameterJdbcTemplate jdbc) {
        return new TitleGroupDAO(jdbc);
    }

    @Bean
    public StudentDAO studentDAO(NamedParameterJdbcTemplate jdbc) {
        return new StudentDAO(jdbc);
    }

    @Bean
    public StudentReader studentReader(Scanner scanner) {
        return new StudentReader(scanner);
    }

    @Bean
    public TitleReader titleReader(Scanner scanner) {
        return new TitleReader(scanner);
    }

    @Bean
    public TitleGroupReader titleGroupReader(Scanner scanner) {
        return new TitleGroupReader(scanner);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(
            @Value("${database.driver}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.user}") String user,
            @Value("${database.password}") String password
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
