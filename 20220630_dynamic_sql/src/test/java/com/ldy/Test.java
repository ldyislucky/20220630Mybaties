package com.ldy;

import com.ldy.mapper.UMapper;
import com.ldy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Test {
  SqlSession sqlSession = null;
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  @Before
  public void kaishi() throws IOException {
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    sqlSession = sqlSessionFactory.openSession();
  }
  @org.junit.Test
  public void jieshu(){
    sqlSession.close();
  }
  @org.junit.Test//动态查询
  public void t1() throws ParseException {
    User user = new User();
    //ser.setUsername("小");
    //user.setAddress("市");
    user.setBirthday(sdf.parse("1996-5-5"));
    UMapper uMapper = sqlSession.getMapper(UMapper.class);
    uMapper.getByCondition(user);
  }
  @org.junit.Test//动态更新
  public void t2() throws ParseException {
    User user = new User();
    user.setId(28);
    user.setUsername("日向雏田");
    user.setBirthday(sdf.parse("2002-1-1"));
    UMapper uMapper = sqlSession.getMapper(UMapper.class);
    int i = uMapper.updateBySet(user);
    sqlSession.commit();
  }
  @org.junit.Test//根据id数组查询
  public void t3(){
    int[] arr = {2,4,6};
    UMapper uMapper = sqlSession.getMapper(UMapper.class);
    List<User> users = uMapper.getByIds(arr);
    users.forEach(u-> System.out.println(u));
  }
  @org.junit.Test//批量增加
  public void t4() throws ParseException {
    List<User> users = new ArrayList<>();
    User user = new User("真数千手", sdf.parse("1940-1-8"), '2', "木叶村");
    users.add(user);
    users.add(user);
    users.add(user);
    UMapper uMapper = sqlSession.getMapper(UMapper.class);
    int i = uMapper.insertMany(users);
    sqlSession.commit();
  }
  @org.junit.Test//使用@param多参数查询
  public void t5() throws ParseException {
    UMapper uMapper = sqlSession.getMapper(UMapper.class);
    List<User> users = uMapper.getByBirthday(sdf.parse("1930-1-1"), sdf.parse("2001-1-1"));
    users.forEach(u-> System.out.println(u));
  }
  @org.junit.Test//使用入参为map多参数查询
  public void t55() throws ParseException {
    Date begin = sdf.parse("1930-1-1");
    Date over = sdf.parse("2001-1-1");
    //map中的key值名称需要与xml文件中的#{}中的名称保持一致
    HashMap<Object, Object> map = new HashMap<>();//类型无需指定
    map.put("begin",begin);
    map.put("over",over);
    UMapper uMapper = sqlSession.getMapper(UMapper.class);
    List<User> users = uMapper.getByBirthday1(map);
    users.forEach(u-> System.out.println(u));
  }
}
