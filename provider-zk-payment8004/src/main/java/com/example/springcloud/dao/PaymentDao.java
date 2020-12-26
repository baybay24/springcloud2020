package com.example.springcloud.dao;

import com.example.springcloud.entities.Payment;

public interface PaymentDao {

    public Payment getPaymentByPort(String port);



}
