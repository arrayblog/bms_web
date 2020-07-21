package cn.arrayblog.example.service;

import cn.arrayblog.example.domain.BookType;

import java.util.List;

public interface IBookTypeService {
    List<BookType> getBookTypeList();
    int addBookType(BookType bookType);
}
