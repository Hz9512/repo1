package com.hz.service.impl;

import com.hz.dao.IProductDao;
import com.hz.domain.Product;
import com.hz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    //查询所有商品
    @Override
    public List<Product> findAll() throws Exception {

        return productDao.findAll();
    }

    //添加商品
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
