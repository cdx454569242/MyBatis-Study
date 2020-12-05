package Dao;

import pojo.Account;
import pojo.AccountUser;
import pojo.User;

import java.util.List;

/**
 * @author
 * @create 2020-10-13 15:28
 */
public interface IAccountDao {

    List<Account> findAll();

    List<AccountUser> findAllAccount();
}
