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

    User findById(Integer id);

    List<User> findByName(String name);

    List<User> findUserByVo(QueryVo vo);


    List<User> findUserByCondition(User user);

    List<User> findUserByInIds(QueryVo vo);
}