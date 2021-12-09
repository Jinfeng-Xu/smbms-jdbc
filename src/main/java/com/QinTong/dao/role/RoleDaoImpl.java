package com.QinTong.dao.role;


import com.QinTong.dao.BaseDao;
import com.QinTong.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    /**
     * 获取角色列表
     *
     * @param connection
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> getRoleList(Connection connection) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Role> roleList = new ArrayList();
        if (connection != null) {
            String sql = "select * from smbms_role";
            Object[] params = {};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                Role _role = new Role();
                _role.setId(rs.getInt("id"));
                _role.setRoleCode(rs.getString("roleCode"));
                _role.setRoleName(rs.getString("roleName"));
                roleList.add(_role);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return roleList;
    }

}
