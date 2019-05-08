/**
 * @author: tang gao liang
 * @time:2019/4/17 22:26:13
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;


public class User {
    private Integer id;
    private String userName;
    private String password;
    private String Salt;
    private int rid = 1;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }
}
