package com.hz.service;

import com.hz.domain.Orders;

import java.util.List;

public interface IOrdersService {


    public List<Orders> findAll(int page,int size) throws Exception;

    public Orders findById(String ordersId) throws Exception;
}
