package Test;

import Dao.IUserDao;
import Dao.Impl.UserDaoImpl;
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
import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2020-10-12 14:57
 */
public class MybatisTest {
    private InputStream in;
    private IUserDao userDao;

    @Before
    public void init()throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destroy() throws IOException {
        in.close();
    }

    @Test
    public void testSelectUser()  {

        List<User> all =  userDao.findAll();
        for (User user : all){
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser() throws IOException {

        User user = new User();
        user.setUserName("save user");
        user.setUserAddress("save Address");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        userDao.saveUser(user);

    }

    @Test
    public void testUpdateUser() throws IOException {

        User user = new User();
        user.setUserId(50);
        user.setUserName("update user");
        user.setUserAddress("update Address");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        userDao.updateUser(user);

    }

    @Test
    public void testDeleteUser() throws IOException {
        userDao.deleteUser(50);
    }

    @Test
    public void testFindByUser() throws IOException {
        User user = userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void testFindByName() throws IOException {
        List<User> users = userDao.findByName("%王%");
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws IOException {
        int total = userDao.findTotal();
        System.out.println(total);
    }

}
