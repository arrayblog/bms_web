package cn.arrayblog.example.dao;

import cn.arrayblog.example.domain.Book;
import cn.arrayblog.example.domain.BookType;

import java.util.List;

public interface IBookTypeDao {
    List<BookType> getBookTypeList();
    int addBookType(BookType bookType);
}
