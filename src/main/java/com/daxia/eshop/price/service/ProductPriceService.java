package com.daxia.eshop.price.service;

import com.daxia.eshop.price.model.ProductPrice;

/**
 * @Description
 * @Author daxia
 * @Date 2019/6/2 10:11
 * @Version 1.0
 */
public interface ProductPriceService {

    public void add(ProductPrice productPrice);

    public void update(ProductPrice productPrice);

    public void delete(Long id);

    public ProductPrice findById(Long id);

    public ProductPrice findByProductId(Long productId);

}
