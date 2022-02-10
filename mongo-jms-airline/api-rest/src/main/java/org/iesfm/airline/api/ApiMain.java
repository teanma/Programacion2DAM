package org.iesfm.airline.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiMain {

    public static void main(String[] args) {
        SpringApplication.run(ApiMain.class);
    }
}
