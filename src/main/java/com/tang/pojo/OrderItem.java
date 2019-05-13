/**
 * @author: tang gao liang
 * @time:2019/4/24 19:13:13
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderItem {
    private int id;
    private User user;
    private Product product;
    private int num;
    private int success = 0;
    private String time;
    private int lastPrice;

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", num=" + num +
                ", success=" + success +
                ", time='" + time + '\'' +
                ", lastPrice=" + lastPrice +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
