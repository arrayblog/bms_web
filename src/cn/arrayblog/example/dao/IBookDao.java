package cn.arrayblog.example.dao;

import cn.arrayblog.example.domain.Book;

import java.util.List;

public interface IBookDao {
    List<Book> getBookList(String keyWord);
    int addBook(Book book);
    int updateBook(Book book);
    Book findById(int bookId);
    int delBook(int bookId);
    int noExistence(int bookId);
    int existence(int bookId);
}
