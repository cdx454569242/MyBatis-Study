package Test;

import Dao.IUserDao;
import com.sun.corba.se.impl.oa.toa.TOA;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author
 * @create 2020-10-14 9:24
 */
public class MyBatisTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("save user");
        user.setAddress("save address");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(50);
        user.setUsername("update user");
        user.setAddress("update address");
        user.setSex("男");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(52);
    }

    @Test
    public void testFindById(){
        User byId = userDao.findById(50);
        System.out.println(byId);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%王%");
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
