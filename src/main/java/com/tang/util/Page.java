/**
 * @author: tang gao liang
 * @time:2019/4/20 11:01:12
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.util;

public class Page {
    int start = 0;
    int count = 5;
    int last = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
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
