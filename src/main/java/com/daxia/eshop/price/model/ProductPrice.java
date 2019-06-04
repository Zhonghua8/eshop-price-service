package com.daxia.eshop.price.model;

/**
 * @Description
 * @Author daxia
 * @Date 2019/6/2 10:07
 * @Version 1.0
 */
public class ProductPrice {
    private Long id;
    private Double value;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
