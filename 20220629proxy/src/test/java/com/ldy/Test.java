package com.ldy;

import com.ldy.mapper.UserMapper;
import com.ldy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Test {
    SqlSession sqlSession = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//创建日期格式刷
    @Before
    public void kaishi() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
    }
    @After
    public void jieshu(){
        sqlSession.close();
    }
    @org.junit.Test//查询全部
    public void t1(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getAll();
        users.forEach(u-> System.out.println(u));
    }
    @org.junit.Test//模糊查询不能防止sql注入
    public void t2(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getByName("王");
        users.forEach(u-> System.out.println(u));
    }
    @org.junit.Test//模糊查询可以防止sql注入
    public void t22(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.goodGetByName("张");
        users.forEach(u-> System.out.println(u));
    }
    @org.junit.Test//灵活的模糊查询可以防止sql注入
    public void t222(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.nimbleGetByName("username","张");
        users.forEach(u-> System.out.println(u));
        List<User> users1 = userMapper.nimbleGetByName("address","市");
        users1.forEach(u-> System.out.println(u));
    }
    @org.junit.Test//更新表  但是这样更新传入的类是不能有空的  有空的执行结果会相当于没有执行
    public void t3() throws ParseException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //sdf.parse("2000-10-08")将字符串刷成日期格式
        User user = new User( "王八蛋",sdf.parse("2000-10-08"),'1',"木叶村");
        user.setId(7);
        int i = userMapper.update(user);
        System.out.println(i);
        sqlSession.commit();
    }
    @org.junit.Test//插入数据
    public void t4() throws ParseException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("佐助", sdf.parse("1997-5-5"), '1', "木叶村");
        int i = userMapper.insert(user);
        System.out.println(i);
        //sqlSession.commit();
    }
    @org.junit.Test//returnId插入数据
    public void t44() throws ParseException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("宇智波鼬", sdf.parse("1996-5-5"), '1', "宇智波一族");
        //已经提交但是却未提交成功也会使得id自增1  返回的依旧是更新值
        int i = userMapper.returnIdInsert(user);
        System.out.println(i);
        sqlSession.commit();
    }

}
