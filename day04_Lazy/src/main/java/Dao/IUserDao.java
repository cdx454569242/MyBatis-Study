package Dao;

import pojo.User;

import java.util.List;

/**
 * @author
 * @create 2020-10-12 14:55
 */
public interface IUserDao {
    List<User> findAll();

    User findById(Integer id);

}