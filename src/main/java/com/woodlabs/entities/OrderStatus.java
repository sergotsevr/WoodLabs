package com.woodlabs.entities;

public enum OrderStatus {
    NOT_PAID("not paid"),
    AWAITONG_SHIPMENT("awaiting shipment"),
    SHIPPED("shipped"),
    DELIVERED("delivered");
    private final String orderStatus;
    private OrderStatus(String orderStatus){
        this.orderStatus=orderStatus;
    }
}
