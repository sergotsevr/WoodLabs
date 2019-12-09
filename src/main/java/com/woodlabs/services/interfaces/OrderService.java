package com.woodlabs.services.interfaces;


import com.woodlabs.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto add(OrderDto orderDto);

    void delete(OrderDto orderDto);

    OrderDto update(OrderDto orderDto);

    List<OrderDto> findAll();

    OrderDto findById(Integer id);

    void deleteById(Integer id);

}
