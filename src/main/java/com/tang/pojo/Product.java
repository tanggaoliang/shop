/**
 * @author: tang gao liang
 * @time:2019/4/21 22:30:26
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

public class Product {
    private int id;
    private String name;
    private String fileName;
    private int price;
    private String info;
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fileName='" + fileName + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", category=" + category.getId() +
                '}';
    }
}
