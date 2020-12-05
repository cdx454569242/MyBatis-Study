package Dao;

import pojo.QueryVo;
import pojo.User;

import java.util.List;

/**
 * @author
 * @create 2020-10-12 14:55
 */
public interface IUserDao {
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findById(Integer id);

    List<User> findByName(String name);

    int findTotal();

    List<User> findUserByVo(QueryVo vo);
}