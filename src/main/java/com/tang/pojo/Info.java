/**
 * @author: tang gao liang
 * @time:2019/4/29 21:18:12
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

/**
 * sex 0 for man 1 for woman
 * default 1 for default
 */
public class Info {
    private int uid;
    private String name;
    private int phoneNumber;
    private String address;
    private int selected;

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
