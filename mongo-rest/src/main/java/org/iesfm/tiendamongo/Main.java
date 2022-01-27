package org.iesfm.tiendamongo;

import org.iesfm.tiendamongo.repository.ArticleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        /*ArticleRepository articleRepository = context.getBean(ArticleRepository.class);

        List<Article> articles = articleRepository.listByArticles();

        for (Article article : articles) {
          System.out.println(article.toString());
        }*/
    }
}
