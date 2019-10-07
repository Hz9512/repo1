package com.hz.service;

import com.hz.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;

    public void save(Product product) throws Exception;
}
