package org.iesfm.tiendamongo.repository;

import org.iesfm.tiendamongo.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Integer> {

    //void insertArticle(Article article);
    //List<Article> listByArticles();
    //List<Article> listOrderArticles(String id);
}
