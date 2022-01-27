package org.iesfm.tiendamongo.repository;

import org.iesfm.tiendamongo.Article;
import org.iesfm.tiendamongo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

    //void insertOrder(Order order);

    /*@Query(
            value = "SELECT o.* FROM orders o INNER JOIN clients c ON c.nif=o.id",
            nativeQuery = true
    )*/

    List<Order> findByNif(String nif);

    //List<Article> listByOrderArticles(int orderId);
}
