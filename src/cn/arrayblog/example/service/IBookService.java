package cn.arrayblog.example.service;

import cn.arrayblog.example.domain.Book;

import java.util.List;

public interface IBookService {
    List getBookList(String keyWord);
    int addBook(Book book);
    int updateBook(Book book);
    Book findById(int bookId);
    int delBook(int bookId);
    int noExistence(int bookId);
    int existence(int bookId);
}
