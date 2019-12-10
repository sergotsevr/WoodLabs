package com.woodlabs.services.implementation;

import com.woodlabs.dto.OrderDto;
import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.entities.Order;
import com.woodlabs.repositories.OrderRepository;
import com.woodlabs.services.interfaces.OrderService;
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
    @Autowired
    ModelMapper modelMapper;
    @Override
    public OrderDto add(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        Order saved = orderRepository.save(order);
        return modelMapper.map(saved, OrderDto.class);
    }

    @Override
    public void delete(OrderDto orderDto) {

    }

    @Override
    public OrderDto update(OrderDto orderDto) {
            Order order = modelMapper.map(orderDto, Order.class);
            Order saved = orderRepository.save(order);
            OrderDto formDb = modelMapper.map(saved, OrderDto.class);
            return formDb;
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(e -> modelMapper.map(e, OrderDto.class)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Integer id) {
        Optional<Order> order =orderRepository.findById(id);
        return modelMapper.map(order.get(), OrderDto.class);
    }

    @Override
    public void deleteById(Integer id) {

    }
}
