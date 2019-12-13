package com.woodlabs.dto;

import com.woodlabs.entities.Address;
import com.woodlabs.entities.Client;
import com.woodlabs.entities.Product;
import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;
import lombok.Data;

import java.util.Map;

@Data
public class OrderDto {

    private Integer orderId;
    private Client client;
    private Address address;
    private PaymentMethod paymentMethod;
    private DeliveryMethod deliveryMethod;
    private Map<Product, Integer> goodsList;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
}
