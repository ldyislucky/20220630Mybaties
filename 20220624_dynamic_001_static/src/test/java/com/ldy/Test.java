package com.ldy;

import com.ldy.proxy.ProxyFactory;
import com.ldy.service.Service;
import com.ldy.service.imp.Agent;
import com.ldy.service.imp.ServiceFu;
import com.ldy.service2.imp.ServiceLIu;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Test {
    @org.junit.Test
    public void t1(){
        Service agent = new Agent(new ServiceFu());
        agent.sing();
    }
    @org.junit.Test
    public void t2(){
        ProxyFactory proxyFactory = new ProxyFactory(new ServiceLIu());
        com.ldy.service2.Service agent = (com.ldy.service2.Service) proxyFactory.getAgent();
        agent.sing();
    }
    @org.junit.Test
    public void t3(){
        ProxyFactory proxyFactory = new ProxyFactory(new com.ldy.service2.imp.ServiceFu());
        com.ldy.service2.Service agent = (com.ldy.service2.Service) proxyFactory.getAgent();
        String s = agent.high(177);
        System.out.println(s);
    }
}
