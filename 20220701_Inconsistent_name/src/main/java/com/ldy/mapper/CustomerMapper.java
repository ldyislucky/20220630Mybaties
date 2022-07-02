package com.ldy.mapper;

import com.ldy.pojo.Customer;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
public interface CustomerMapper {
    List<Customer> getById(int id);
}
