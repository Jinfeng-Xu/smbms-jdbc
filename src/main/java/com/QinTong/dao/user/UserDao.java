package com.QinTong.dao.user;

import com.QinTong.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //得到登陆的用户
    public User getLoginUser(Connection connection, String userCode);

    //修改当前用户密码
    public int updatePwd(Connection connection, int id, String password);

    //查询用户总数
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException;

    //用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

    //delete user by id
    public int deleteUserById(Connection connection, Integer delId) throws Exception;

    //get user by id
    public User getUserById(Connection connection, String id) throws Exception;

    //modify user's informations
    public int modify(Connection connection, User user) throws Exception;

    //add user's informations;
    public int add(Connection connection, User user) throws Exception;
}
