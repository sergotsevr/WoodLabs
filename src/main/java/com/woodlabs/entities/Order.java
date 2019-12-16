package com.woodlabs.entities;

import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "ClientId")
    private Client client;
    @ManyToOne()
    @JoinColumn(name = "AddressId")
    private Address address;
    @Column
    @CollectionTable(name = "payment_Method", joinColumns = @JoinColumn(name = "order_orderId"))
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Column
    @CollectionTable(name = "delivery_Method", joinColumns = @JoinColumn(name = "order_orderId"))
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;
    @ElementCollection
    @MapKeyColumn(name = "product_product_id")
    @Column(name = "amount")
    private Map<Product, Integer> goodsList = new LinkedHashMap<>();;
    @Column
    @CollectionTable(name = "payment_Status", joinColumns = @JoinColumn(name = "order_orderId"))
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Column
    @CollectionTable(name = "order_Status", joinColumns = @JoinColumn(name = "order_orderId"))
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
