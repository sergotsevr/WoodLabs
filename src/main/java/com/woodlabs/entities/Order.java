package com.woodlabs.entities;

import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @ManyToOne
    @JoinColumn(name = "ClientId")
    private Client client;
    @ManyToOne()
    @JoinColumn(name = "AddressId")
    private Address address;
    @Column
    private PaymentMethod paymentMethod;
    @Column
    private DeliveryMethod deliveryMethod;

    @ManyToMany
    @JoinTable(name = "ordersProduct",
            joinColumns = @JoinColumn(name = "ORDERS_ID"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> goodsList;
    @Column
    private PaymentStatus paymentStatus;
    @Column
    private OrderStatus orderStatus;
}
