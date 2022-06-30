package com.ldy.service.imp;

import com.ldy.service.Service;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Agent implements Service {
  private Service service;

  public Agent(Service service) {
    this.service = service;
  }

  @Override
  public void sing() {
    System.out.println("谈场地");
    System.out.println("谈费用");

    service.sing();

    System.out.println("结束演唱");
  }
}
