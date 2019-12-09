package com.woodlabs.controllers;

import com.woodlabs.dto.OrderDto;
import com.woodlabs.entities.Order;
import com.woodlabs.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/order")
public class OderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public String main(Model model){
        List<OrderDto> orderDtos = orderService.findAll();
        model.addAttribute("orders", orderDtos);
        return "order/orderMain";
    }
    @GetMapping("/update")
    public String update(Integer id, Model model){
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute("order", orderDto);
        return "order/orderUpdate";
    }

}
