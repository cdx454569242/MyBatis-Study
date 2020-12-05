package Dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import pojo.Account;

import java.util.List;

/**
 * @author
 * @create 2020-10-14 15:14
 */
public interface IAccountDao {

    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one=@One( select="Dao.IUserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountByUid(Integer uid);
}
