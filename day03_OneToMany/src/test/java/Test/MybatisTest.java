package Test;

import Dao.IAccountDao;
import Dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Account;
import pojo.AccountUser;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2020-10-12 14:57
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDaoDao;

    @Before
    public void init()throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountDaoDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> all = accountDaoDao.findAll();
        for(Account account : all){
            System.out.println("---------------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAllAccount(){
        List<AccountUser> all = accountDaoDao.findAllAccount();
        for(AccountUser au : all){
            System.out.println(au);
        }
    }

}
