package com.daxia.eshop.price.mapper;

import com.daxia.eshop.price.model.ProductPrice;
import org.apache.ibatis.annotations.*;

/**
 * @Description
 * @Author daxia
 * @Date 2019/6/2 10:08
 * @Version 1.0
 */
@Mapper
public interface ProductPriceMapper {

    @Insert("insert into product_price (value, product_id) values (#{value},#{productId})")
    public void add(ProductPrice productPrice);

    @Update("update product_price set value = #{value}, product_id = #{productId} where id = #{id}")
    public void update(ProductPrice productPrice);

    @Delete("delete from product_price where id = #{id}")
    public void delete(@Param("id") Long id);

    @Select("select * from product_price where id = #{id}")
    public ProductPrice findById(@Param("id") Long id);
}
