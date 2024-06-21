package com.xcelore.ordermicroservice.service;

import com.xcelore.ordermicroservice.controller.ProductClient;
import com.xcelore.ordermicroservice.controller.UserClient;
import com.xcelore.ordermicroservice.entity.Order;
import com.xcelore.ordermicroservice.repository.OrderRepository;
import com.xcelore.productmicroservice.entity.Product;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    public Order saveOrder(Order order) {
        User user = userClient.getUserById(order.getUserId());
        Product product = productClient.getProductById(order.getProductId());
        if (user != null && product != null) {
            return orderRepository.save(order);
        }
        return null;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
