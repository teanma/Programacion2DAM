package org.iesfm.tiendamongo.controller;

import org.iesfm.tiendamongo.Article;
import org.iesfm.tiendamongo.Client;
import org.iesfm.tiendamongo.Order;
import org.iesfm.tiendamongo.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
        if (!orderRepository.existsById(order.getId())) {
            orderRepository.save(order);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Order already exists");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/clients/{nif}/orders")
    public List<Order> list(@PathVariable String nif) {
        return orderRepository.findByNif(nif);
    }
}
