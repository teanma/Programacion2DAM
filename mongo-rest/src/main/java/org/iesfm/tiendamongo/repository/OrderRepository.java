package org.iesfm.tiendamongo.repository;

import org.iesfm.tiendamongo.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository extends MongoRepository<Order, Integer> {

    void insertOrder(Order order);

    @Query(
            value = "SELECT o.* FROM orders o INNER JOIN clients c ON c.nif=o.id",
            nativeQuery = true
    )

    List<Order> listClientOrders();
}
