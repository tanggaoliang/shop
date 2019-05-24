/**
 * @author: tang gao liang
 * @time:2019/4/20 11:01:12
 * @unique: 唐高亮LIANG
 * @qq:1440535574 count分八页
 * pageCount总页数
 */
package com.tang.util;

public class Page {
    String name;
    int cid = 1;
    Integer start = 0;
    int count = 8;
    int last = 0;
    int total = 0;
    int pageNum = 1;
    int pageCount = 1;

    public int getPageCount() {

        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        int a = this.start / this.count + 1;

        return a;
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        if (null == start) {
            start = 0;
        }
        if (start < 0) {
            start = 0;
        }
        if (start > last) {
            start = last;
        }
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void calculateLast(int total) {
        if (0 == total % count) {
            last = total - count;
        } else {
            last = total - total % -count;
        }
    }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", last=" + last +
                '}';
    }
}
