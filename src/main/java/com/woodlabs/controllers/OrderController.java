package com.woodlabs.controllers;

import com.woodlabs.dto.OrderDto;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;
import com.woodlabs.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/order")
public class OrderController {
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
        List<PaymentMethod> paymentMethods = Arrays.asList(PaymentMethod.values());
        model.addAttribute("paymentMethods", paymentMethods);
        List<DeliveryMethod> deliveryMethods = Arrays.asList(DeliveryMethod.values());
        model.addAttribute("deliveryMethods", deliveryMethods);
        List<PaymentStatus> paymentStatuses = Arrays.asList(PaymentStatus.values());
        model.addAttribute("paymentStatuses", paymentStatuses);
        List<OrderStatus> orderStatuses = Arrays.asList(OrderStatus.values());
        model.addAttribute("orderStatuses", orderStatuses);
        return "order/orderUpdate";
    }
    @PostMapping("/update")
    public String update(OrderDto orderDto, Model model){
        orderService.update(orderDto);
        return "redirect:";
    }
    @GetMapping("/productUpdate")
    public String productUpdate(Integer id, Model model){
        OrderDto orderDto = orderService.findById(id);
        List<Product> products= orderDto.getGoodsList();
        model.addAttribute("products", products);
        return "order/productInOrder";
    }
    @PostMapping("/productUpdate")
    public String productUpdate(Product[] products, Model model){
        System.err.println(products[0]);
        return "order/productInOrder";
    }
}
