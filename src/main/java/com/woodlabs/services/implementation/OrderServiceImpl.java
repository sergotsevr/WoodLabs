package com.woodlabs.services.implementation;

import com.woodlabs.dto.OrderDto;
import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.entities.Order;
import com.woodlabs.repositories.OrderRepository;
import com.woodlabs.services.interfaces.OrderService;
import com.woodlabs.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Component
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderDto add(OrderDto orderDto) {
        Order order = Mapper.toOrder(orderDto);
        Order saved = orderRepository.save(order);
        return Mapper.toOrderDto(saved);
    }

    @Override
    public void delete(OrderDto orderDto) {
        Order order = Mapper.toOrder(orderDto);
        orderRepository.delete(order);
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
            Order order = Mapper.toOrder(orderDto);
            Order saved = orderRepository.save(order);
            OrderDto formDb = Mapper.toOrderDto(saved);
            return formDb;
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(e -> Mapper.toOrderDto(e)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Integer id) {
        Optional<Order> order =orderRepository.findById(id);
        return Mapper.toOrderDto(order.get());
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
