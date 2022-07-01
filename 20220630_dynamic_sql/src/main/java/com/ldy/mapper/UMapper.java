package com.ldy.mapper;

import com.ldy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : ldy
 * @version : 1.0
 */
public interface UMapper {
    List<User> getByCondition(User user);//爆红是插件的问题，可以正常使用
    int updateBySet(User user);
    List<User> getByIds(int[] arr);//批量查询
    int insertMany(List<User> list);
    List<User> getByBirthday(
            @Param("begin")
            Date begin,
            @Param("over")
            Date over
    );
    List<User> getByBirthday1(Map map);
}
