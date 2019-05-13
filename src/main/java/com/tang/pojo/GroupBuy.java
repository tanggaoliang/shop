/**
 * @author: tang gao liang
 * @time:2019/5/12 19:48:53
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

import java.util.List;

/**
 * 3人一个团
 */
public class GroupBuy {
    private int id;
    private Integer uid1;
    private Integer uid2;
    private Integer uid3;
    private int pid;
    private int num1;
    private int num2;
    private int num3;
    private int userNum;

    @Override
    public String toString() {
        return "GroupBuy{" +
                "id=" + id +
                ", uid1=" + uid1 +
                ", uid2=" + uid2 +
                ", uid3=" + uid3 +
                ", pid=" + pid +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", userNum=" + userNum +
                '}';
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUid1() {
        return uid1;
    }

    public void setUid1(Integer uid1) {
        this.uid1 = uid1;
    }

    public Integer getUid2() {
        return uid2;
    }

    public void setUid2(Integer uid2) {
        this.uid2 = uid2;
    }

    public Integer getUid3() {
        return uid3;
    }

    public void setUid3(Integer uid3) {
        this.uid3 = uid3;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }
}
