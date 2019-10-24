package com.woodlabs.entities;

import com.woodlabs.entities.enums.DeliveryMethod;
import com.woodlabs.entities.enums.OrderStatus;
import com.woodlabs.entities.enums.PaymentMethod;
import com.woodlabs.entities.enums.PaymentStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinTable(name = "CLIENT",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID")
    )
    private Client client;
    @Column
    private String address;
    @Column
    private PaymentMethod paymentMethod;
    @Column
    private DeliveryMethod deliveryMethod;
    /*@ElementCollection
    @CollectionTable(name ="goods" , joinColumns=@JoinColumn(name="goods_id"))
    @Column
    private List<Integer> goods;*/
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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
