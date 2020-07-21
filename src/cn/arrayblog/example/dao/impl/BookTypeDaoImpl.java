package cn.arrayblog.example.dao.impl;

import cn.arrayblog.example.dao.IBookTypeDao;
import cn.arrayblog.example.domain.BookType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDaoImpl implements IBookTypeDao {

    public Connection conn=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;

    @Override
    public List<BookType> getBookTypeList() {
        List<BookType> bookTypes =new ArrayList();

        String sql = "select * from book_type";

        conn = BasicDaoImpl.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                BookType bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("book_type_name"));
                bookType.setBookTypeDesc(rs.getString("book_type_desc"));
                bookTypes.add(bookType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BasicDaoImpl.clossAll(conn,ps,rs);
        }
        return bookTypes;
    }

    @Override
    public int addBookType(BookType bookType) {
        String sql = "insert into book_type(book_type_name,book_type_desc) values(?,?)";
        String arrp[] = {bookType.getBookTypeName(),bookType.getBookTypeDesc()};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }
}
