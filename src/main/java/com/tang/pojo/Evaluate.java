/**
 * @author: tang gao liang
 * @time:2019/5/9 14:20:29
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

/**
 * starNum 几颗星星
 */
public class Evaluate {
    private int id;
    private Product product;
    private User user;
    private int starNum;
    private String content;
    private String time;

    @Override
    public String toString() {
        return "Evaluate{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                ", starNum=" + starNum +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
