/**
 * @author: tang gao liang
 * @time:2019/4/24 19:13:13
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

public class OrderItem {
    private int id;
    private User user;
    private Product product;
    private int num;
    private int success;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
//                ", user=" + user +
                ", product=" + product +
                ", num=" + num +
                ", success=" + success +
                '}';
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
