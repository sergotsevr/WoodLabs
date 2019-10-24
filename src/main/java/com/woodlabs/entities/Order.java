package com.woodlabs.entities;

import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinTable(name = "CLIENT",
            joinColumns = @JoinColumn(name = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID")
    )
    private Client client;
    @ManyToOne
    @JoinTable(name = "ADDRESS",
            joinColumns = @JoinColumn(name = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID")
    )
    private Address address;
    @Column
    private PaymentMethod paymentMethod;
    @Column
    private DeliveryMethod deliveryMethod;
    @ElementCollection
    @CollectionTable(name = "Goods", joinColumns = @JoinColumn(name = "ID"))
    @Column(name = "goods")
    private List<Integer> goods;
    @Column
    private PaymentStatus paymentStatus;
    @Column
    private OrderStatus orderStatus;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

   /* public List<Integer> getGoods() {
        return goods;
    }

    public void setGoods(List<Integer> goods) {
        this.goods = goods;
    }*/

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
