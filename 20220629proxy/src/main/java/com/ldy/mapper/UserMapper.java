package com.ldy.mapper;

import com.ldy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
public interface UserMapper {
    List<User> getAll();
    List<User> getByName(String username);
    List<User> goodGetByName(String username);
    List<User> nimbleGetByName(
            @Param("columnName")
            String columnName,
            @Param("columnNameValue")
            String columnNameValue);
    int update(User user);
    int insert(User user);
    int returnIdInsert(User user);
}
