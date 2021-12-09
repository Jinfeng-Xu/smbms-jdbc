package com.QinTong.service.user;

import com.QinTong.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserService {
    public User login(String userCode, String password);
    public boolean updatePwd( int id, String password);
    public int getUserCount(String username, int userRole);
    public boolean add(User user);
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
    public User selectUserCodeExist(String userCode);
    public boolean deleteUserById(Integer delId);
    public User getUserById(String id);
    public boolean modify(User user);
}
