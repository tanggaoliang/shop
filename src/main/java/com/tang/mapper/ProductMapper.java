/**
 * @author: tang gao liang
 * @time:2019/4/22 9:23:20
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.mapper;

import com.tang.pojo.Product;
import com.tang.util.Page;

import java.util.List;

public interface ProductMapper {
    int add(Product product);

    void delete(int id);

    Product get(int id);

    int update(Product product);

    List<Product> listByCid(int cid);

    int countByCid(int cid);

    List<Product> listByCidByCount(Page page);

    List<Product> listByNameByPage(Page page);

    List<Product> listAll();

    Product addProduct();

    void insertOnlyId(int id);

    int biGIndex();

    List<Product> listByName(String name);

}
