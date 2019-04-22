/**
 * @author: tang gao liang
 * @time:2019/4/22 9:23:20
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.mapper;

import com.tang.pojo.Product;

import java.util.List;

public interface ProductMapper {
    public int add(Product product);

    public void delete(int id);

    public Product get(int id);

    public int update(Product product);

    public List<Product> list();

}
