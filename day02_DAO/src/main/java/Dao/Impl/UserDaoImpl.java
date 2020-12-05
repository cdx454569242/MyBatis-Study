package Dao.Impl;

import Dao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;

import java.util.List;

/**
 * @author
 * @create 2020-10-12 20:16
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        List<User> users = sqlSession.selectList("Dao.IUserDao.findAll");
        sqlSession.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer id) {

    }

    public User findById(Integer id) {
        return null;
    }

    public List<User> findByName(String name) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
