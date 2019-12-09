package com.woodlabs.entities;

import com.woodlabs.entities.enums.*;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

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
    @ManyToMany
    @JoinTable(name = "ordersProduct",
            joinColumns = @JoinColumn(name = "ORDERS_ID"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> goodsList;
    @Column
    @CollectionTable(name = "payment_Status", joinColumns = @JoinColumn(name = "order_orderId"))
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Column
    @CollectionTable(name = "order_Status", joinColumns = @JoinColumn(name = "order_orderId"))
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
