package com.ldy;

import com.ldy.product.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Test {
  SqlSession sqlSession = null;
  @Before//在每一个程序执行之前执行本方法
  public void opensession() throws IOException {
    //使用文件流读取核心配置文件
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    //创建sqlsessionfactory（sql会话工厂）
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    //从会话工厂创建sqlSession     sql会话
    sqlSession = sqlSessionFactory.openSession();
  }
  @After
  public void closesession(){
    sqlSession.close();
  }
  @org.junit.Test//查询全部
  public void t1() throws IOException {
    //取出数据库的人员集合
    List<Person> persons = sqlSession.selectList("Person.getAll");
    persons.forEach(p-> System.out.println(p));
    sqlSession.close();
  }
  @org.junit.Test
  public void t2() throws IOException {
    //取出数据库的人员集合
    Person person = sqlSession.selectOne("Person.getId", 3);
    System.out.println(person);
  }
  @org.junit.Test//多个问号查询配置
  public void t3() throws IOException {
    //取出数据库的人员集合
    Person person1 = new Person();
    person1.setId(1);
    person1.setName("张三");
    Person person = sqlSession.selectOne("Person.getId",person1 );
    System.out.println(person);
  }
  @org.junit.Test//多个问号查询配置
  public void t33() throws IOException {
    //取出数据库的人员集合
    Person person1 = new Person();
    person1.setAge(22);
    person1.setName("张三");
    List<Person> persons = sqlSession.selectList("Person.getId",person1);
    persons.forEach(p-> System.out.println(p));
  }
  @org.junit.Test
  public void t4() throws IOException {
    //取出数据库的人员集合
    List<Person> ps = sqlSession.selectList("Person.getName","张");
    ps.forEach(p-> System.out.println(p));
  }
  @org.junit.Test//表插入
  public void t5() throws IOException {
    Person person = new Person();
    person.setName("老六");
    person.setEmail("9999999");
    person.setAge(18);
    int i = sqlSession.insert("Person.insertPerson", person);
    System.out.println(i);
    sqlSession.commit();//若是不提交事务表不会发生变化
  }
  @org.junit.Test//表更新
  public void t6() throws IOException {
    Person person = new Person();
    person.setId(7);
    person.setName("老八");
    person.setEmail("777777777");
    person.setAge(35);
    int i = sqlSession.update("Person.upDatePerson", person);
    System.out.println(i);
    sqlSession.commit();//若是不提交事务表不会发生变化
  }


}
