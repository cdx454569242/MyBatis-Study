package Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.User;

import java.util.List;

/**
 * @author
 * @create 2020-10-14 9:12
 */
public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);
    
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    @Select("select * from user where username like #{name}")
    List<User> findUserByName(String name);

    @Select("select count(*) from user")
    int findTotal();
}
