package com.ldy.service2.imp;

import com.ldy.service2.Service;

/**
 * @author : ldy
 * @version : 1.0
 */
public class ServiceFu implements Service {
    @Override
    public void sing() {
        System.out.println("郭富城唱歌！");
    }

    @Override
    public String high(int hi) {
        System.out.println("郭富城身高"+hi);
        return "去你的";
    }
}
