package com.ldy.service2.imp;

import com.ldy.service2.Service;

/**
 * @author : ldy
 * @version : 1.0
 */
public class ServiceLIu implements Service {

    @Override
    public void sing() {
        System.out.println("刘德华开始唱歌");
    }

    @Override
    public String high(int hi) {
        System.out.println("刘德华身高"+hi);
        String st = "刘德华";
        return st;
    }
}
