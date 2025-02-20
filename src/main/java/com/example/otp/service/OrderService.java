package com.example.otp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.otp.model.Order;
import com.example.otp.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setProductId(orderDetails.getProductId());
                    order.setQuantity(orderDetails.getQuantity());
                    order.setCustomerName(orderDetails.getCustomerName());
                    order.setStatus(orderDetails.getStatus());
                    order.setAddress(orderDetails.getAddress());
                    return orderRepository.save(order);
                })
                .orElseThrow();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
