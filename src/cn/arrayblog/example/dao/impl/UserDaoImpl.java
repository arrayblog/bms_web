package cn.arrayblog.example.dao.impl;

import cn.arrayblog.example.dao.IUserDao;
import cn.arrayblog.example.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    public Connection conn=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;


    @Override
    public User login(User user){
        User activeUser = null;
        String sql = "select * from user where username=? and password=?";
        conn = BasicDaoImpl.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2, user.getPassword());
            rs=ps.executeQuery();
            if(rs.next()){
                activeUser = new User();
                activeUser.setId(rs.getInt("id"));
                activeUser.setUsername(rs.getString("username"));
                activeUser.setPassword(rs.getString("password"));
                activeUser.setUserLevel(rs.getInt("user_level"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BasicDaoImpl.clossAll(conn,ps,rs);
        }
        return activeUser;
    }
}
