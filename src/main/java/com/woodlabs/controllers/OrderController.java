package com.woodlabs.controllers;

import com.woodlabs.dto.OrderDto;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;
import com.woodlabs.services.interfaces.OrderService;
import com.woodlabs.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @GetMapping("/create")
    public String create(Model model){
        OrderDto orderDto = new OrderDto();
        model.addAttribute("order", orderDto);
        List<PaymentMethod> paymentMethods = Arrays.asList(PaymentMethod.values());
        model.addAttribute("paymentMethods", paymentMethods);
        List<DeliveryMethod> deliveryMethods = Arrays.asList(DeliveryMethod.values());
        model.addAttribute("deliveryMethods", deliveryMethods);
        List<PaymentStatus> paymentStatuses = Arrays.asList(PaymentStatus.values());
        model.addAttribute("paymentStatuses", paymentStatuses);
        List<OrderStatus> orderStatuses = Arrays.asList(OrderStatus.values());
        model.addAttribute("orderStatuses", orderStatuses);
        return "order/orderCreate";
    }
    @PostMapping("/create")
    public String create(OrderDto orderDto, Model model){
        orderService.add(orderDto);
        return "redirect:";
    }
    @GetMapping("/productUpdate")
    public String productUpdate(Integer id, Model model){
        OrderDto orderDto = orderService.findById(id);
        Map<Product, Integer> products= orderDto.getGoodsList();
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Product, Integer>  entry : products.entrySet()) {
            productList.add(entry.getKey());
        }
        model.addAttribute("products", products);
        model.addAttribute("id", id);
        return "order/productInOrder";
    }
    @RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
    public String productUpdate(Model model, @RequestParam Map<String,String> allParams){
        for (Map.Entry<String, String> product : allParams.entrySet()) {
            if (Util.isNumeric(product.getKey())){
                //product
            }
        }
        Integer id = Integer.parseInt(allParams.get("id"));
        return "redirect:productUpdate?id="+id;
    }
    @GetMapping("/delete")
    public String delete(Integer id, Model model){
        orderService.deleteById(id);
        return "redirect:";
    }
}
