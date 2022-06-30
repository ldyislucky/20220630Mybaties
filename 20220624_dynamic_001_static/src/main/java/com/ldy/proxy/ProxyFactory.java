package com.ldy.proxy;

import com.ldy.service2.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : ldy
 * @version : 1.0
 * 本类是用来生产代理商的，相当于生成service包中的agent
 */
public class ProxyFactory {
  private Service service;

  public ProxyFactory(Service service) {
    this.service = service;
  }

  public Object getAgent(){
    return Proxy.newProxyInstance(
            service.getClass().getClassLoader(),//代理对象类加载器
            service.getClass().getInterfaces(),//代理对象实现接口
            new InvocationHandler() {
              @Override
              public Object invoke(Object proxy, //创建的代理对象
                                   Method method,//目标方法sing()
                                   Object[] args//目标方法的参数,一般没啥用
              ) throws Throwable {
                System.out.println("谈场地");
                System.out.println("谈费用");

                  Object ob = method.invoke(service, args);//方法的返回值，有了这个有返回值的方法才能获取返回值

                  System.out.println("结束演唱");
                return ob;//
              }
            }
    );
  }
}
