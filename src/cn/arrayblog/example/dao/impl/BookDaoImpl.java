package cn.arrayblog.example.dao.impl;

import cn.arrayblog.example.dao.IBookDao;
import cn.arrayblog.example.domain.Book;
import cn.arrayblog.example.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {

    public Connection conn=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;

    @Override
    public List getBookList(String keyWord) {

        List<Book> books =new ArrayList();

        String sql = "select * from book";
        if(keyWord !=null&&!"".equals(keyWord)){
            sql+=" where book_name like '%"+keyWord+"%' or book_desc like '%"+keyWord+"%' or author like '%"+keyWord+"%'";
        }
        conn = BasicDaoImpl.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                book.setBookDesc(rs.getString("book_desc"));
                book.setBookTypeId(rs.getInt("book_type_id"));
                book.setIsExistence(rs.getInt("is_existence"));
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BasicDaoImpl.clossAll(conn,ps,rs);
        }
        return books;
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into book(book_name,author,price,book_desc,book_type_id,is_existence) values(?,?,?,?,?,1)";
        String arrp[] = {book.getBookName(), book.getAuthor(), String.valueOf(book.getPrice()), book.getBookDesc(), String.valueOf(book.getBookTypeId())};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set book_name=?,author=?,price=?,book_desc=?,book_type_id=? where id=?";
        String arrp[] = {book.getBookName(), book.getAuthor(), String.valueOf(book.getPrice()), book.getBookDesc(), String.valueOf(book.getBookTypeId()),String.valueOf(book.getId())};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }

    @Override
    public Book findById(int bookId) {
        Book book = new Book();
        String sql = "select * from book where id=?";
        conn = BasicDaoImpl.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,bookId);
            rs=ps.executeQuery();
            while(rs.next()){
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                book.setBookDesc(rs.getString("book_desc"));
                book.setBookTypeId(rs.getInt("book_type_id"));
                book.setIsExistence(rs.getInt("is_existence"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BasicDaoImpl.clossAll(conn,ps,rs);
        }
        return book;
    }

    @Override
    public int delBook(int bookId) {
        String sql = "delete from book where id=?";
        String arrp[] = {String.valueOf(bookId)};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }

    @Override
    public int noExistence(int bookId) {
        String sql = "update book set is_existence=0 where id=?";
        String arrp[] = {String.valueOf(bookId)};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }

    @Override
    public int existence(int bookId) {
        String sql = "update book set is_existence=1 where id=?";
        String arrp[] = {String.valueOf(bookId)};
        int i = BasicDaoImpl.executeSql(sql, arrp);
        return i;
    }

}
