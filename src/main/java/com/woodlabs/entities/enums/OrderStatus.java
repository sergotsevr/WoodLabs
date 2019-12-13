package com.woodlabs.entities.enums;

public enum OrderStatus {
    NOT_PAID("not paid"),
    AWAITING_SHIPMENT("awaiting shipment"),
    SHIPPED("shipped"),
    DELIVERED("delivered");
    private final String orderStatus;

    private OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
