package org.iesfm.tiendamongo.controller;

import org.iesfm.tiendamongo.Article;
import org.iesfm.tiendamongo.repository.ArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ArticleController {

    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/articles")
    public void insert(@RequestBody Article article) {
        if (articleRepository.existsById(article.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Article already exists");
        } else {
            articleRepository.insertArticle(article);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles")
    public List<Article> list() {
        return articleRepository.listArticles();
    }
}
