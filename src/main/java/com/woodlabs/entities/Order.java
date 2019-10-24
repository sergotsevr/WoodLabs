package com.woodlabs.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    Client client;
    @Column
    String address;
    @Column
    PaymentMethod paymentMethod;
    @Column
    DeliveryMethod deliveryMethod;
    @Column
    List<Integer> goods;
    @Column
    PaymentStatus paymentStatus;
    @Column
    OrderStatus orderStatus;

}
