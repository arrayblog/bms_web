package cn.arrayblog.example.dao.impl;

import cn.arrayblog.example.dao.IRecordDao;
import cn.arrayblog.example.domain.Book;
import cn.arrayblog.example.domain.Record;
import cn.arrayblog.example.utils.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDaoImpl implements IRecordDao {

    public Connection conn=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;

    @Override
    public int addRecord(int userId,int bookId) {
        String sql = "insert into record(user_id,book_id,date) values(?,?,?)";
        String arrp[] = {String.valueOf(userId), String.valueOf(bookId), DateTime.DateTimeToString()};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }

    @Override
    public int removeRecord(int recordId) {
        String sql = "delete from record where id=?";
        String arrp[] = {String.valueOf(recordId)};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }

    @Override
    public int userRecordNumber(int userId) {

        int i = 0;

        String sql = "select count(id) as total from record where user_id=?";
        conn = BasicDaoImpl.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs=ps.executeQuery();
            while(rs.next()){
                i = rs.getInt("total");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BasicDaoImpl.clossAll(conn,ps,rs);
        }
        return i;

    }

    @Override
    public List<Record> getUserRecordList(int userId) {
        List<Record> records =new ArrayList();

        String sql = "select * from record where user_id=?";

        conn = BasicDaoImpl.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs=ps.executeQuery();
            while(rs.next()){
                Record record = new Record();
                record.setId(rs.getInt("id"));
                record.setUserId(rs.getInt("user_id"));
                record.setBookId(rs.getInt("book_id"));
                record.setDate(rs.getDate("date"));
                records.add(record);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BasicDaoImpl.clossAll(conn,ps,rs);
        }
        return records;
    }

}
