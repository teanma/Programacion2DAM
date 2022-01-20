package org.iesfm.tiendamongo.controller;

import org.aspectj.weaver.ast.Or;
import org.iesfm.tiendamongo.Article;
import org.iesfm.tiendamongo.Client;
import org.iesfm.tiendamongo.Order;
import org.iesfm.tiendamongo.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/orders")
    public void insert(@RequestBody Order order) {
        if (orderRepository.existsById(order.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Order already exists");
        } else {
            orderRepository.insertOrder(order);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/orders")
    public List<Order> list() {
        return orderRepository.listClientOrders();
    }
}
