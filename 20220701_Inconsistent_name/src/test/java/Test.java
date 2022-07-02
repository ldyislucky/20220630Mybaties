import com.ldy.mapper.CustomerMapper;
import com.ldy.mapper.PersonMapper;
import com.ldy.pojo.Customer;
import com.ldy.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

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
    @org.junit.Test//因为数据库的名称和类的名称是不一致的 所以本次测试名称不一致的列会接收为空值
    public void t1(){
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> all = mapper.getAll();
        all.forEach(a-> System.out.println(a));
    }
    @org.junit.Test//上述问题解决方案是改别名
    public void t2(){
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> all = mapper.getAll1();
        all.forEach(a-> System.out.println(a));
    }
    @org.junit.Test//通过映射绑定数据库的列名和类的属性名来解决名称不一致问题
    public void t3(){
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> all = mapper.getAll3();
        all.forEach(a-> System.out.println(a));
    }
    @org.junit.Test//多对一
    public void t4(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.getById(1);
        System.out.println(customers);
    }

}