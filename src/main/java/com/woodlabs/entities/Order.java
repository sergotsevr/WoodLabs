package com.woodlabs.entities;

import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;

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
