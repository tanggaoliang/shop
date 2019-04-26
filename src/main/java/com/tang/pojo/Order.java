/**
 * @author: tang gao liang
 * @time:2019/4/24 19:23:05
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.pojo;

import java.util.Date;

/**
 * oiid 订单项的id
 */
public class Order {
    private int id;
    private int oiid;
    private Date date;

    public int getOiid() {
        return oiid;
    }

    public void setOiid(int oiid) {
        this.oiid = oiid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
