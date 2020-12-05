package Dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import pojo.User;

import java.util.List;

/**
 * @author
 * @create 2020-10-14 9:12
 */
public interface IUserDao {
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(property = "accounts",column = "id",many = @Many(select = "Dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    @Select("select * from user where username like #{name}")
    List<User> findUserByName(String name);


}
