package com.kodilla.ecommerce.service;

public class OrderNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "com.kodilla.ecommerce.service.OrderNotFoundException: no order with given ID";
    }
}
