package com.daxia.eshop.price.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.daxia.eshop.price.mapper.ProductPriceMapper;
import com.daxia.eshop.price.model.ProductPrice;
import com.daxia.eshop.price.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description
 * @Author daxia
 * @Date 2019/6/2 10:12
 * @Version 1.0
 */

@Service("productPriceService")
public class ProductPriceServiceImpl implements ProductPriceService {
    
    @Autowired
    private ProductPriceMapper productPriceMapper;
    
    @Autowired
    private JedisPool jedisPool;
    
    @Override
    public void add(ProductPrice productPrice) {
        productPriceMapper.add(productPrice);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
    }

    @Override
    public void delete(Long id) {
        ProductPrice productPrice = findById(id);
        productPriceMapper.delete(id);
        Jedis jedis = jedisPool.getResource();
        jedis.del("product_price_" + productPrice.getProductId());
    }

    @Override
    public ProductPrice findById(Long id) {
        return productPriceMapper.findById(id);
    }

    @Override
    public ProductPrice findByProductId(Long productId) {
        Jedis jedis = jedisPool.getResource();
        String dataJSON = jedis.get("product_price_"+productId);
        if(dataJSON != null && !"".equals(dataJSON)){
            JSONObject dataJSONObject = JSONObject.parseObject(dataJSON);
            dataJSONObject.put("id", "-1");
            return JSONObject.parseObject(dataJSONObject.toJSONString(), ProductPrice.class);
        }
        
        return productPriceMapper.findByProductId(productId);
    }
}
