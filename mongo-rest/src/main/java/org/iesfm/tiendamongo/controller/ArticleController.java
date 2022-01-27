package org.iesfm.tiendamongo.controller;

import org.iesfm.tiendamongo.Article;
import org.iesfm.tiendamongo.repository.ArticleRepository;
import org.iesfm.tiendamongo.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ArticleController {

    private ArticleRepository articleRepository;
    private OrderRepository orderRepository;

    public ArticleController(ArticleRepository articleRepository, OrderRepository orderRepository) {
        this.articleRepository = articleRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/articles")
    public void insert(@RequestBody Article article) {
        if (!articleRepository.existsById(article.getId())) {
            articleRepository.save(article);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Article already exists");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles")
    public List<Article> list() {
        return articleRepository.findAll();
    }

    /*@RequestMapping(method = RequestMethod.GET, path = "/orders/{id}/articles")
    public List<Article> getOrderArticles(@PathVariable ("id") int id) {
        return orderRepository.listByOrderArticles(id);
    }*/
}
