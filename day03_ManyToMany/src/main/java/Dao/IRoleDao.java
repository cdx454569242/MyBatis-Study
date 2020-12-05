package Dao;

import pojo.Role;

import java.util.List;

/**
 * @author
 * @create 2020-10-13 18:55
 */
public interface IRoleDao {
    List<Role> findAll();
}
