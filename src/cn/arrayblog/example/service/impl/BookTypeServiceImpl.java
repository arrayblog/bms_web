package cn.arrayblog.example.service.impl;

import cn.arrayblog.example.dao.IBookTypeDao;
import cn.arrayblog.example.dao.impl.BookTypeDaoImpl;
import cn.arrayblog.example.domain.BookType;
import cn.arrayblog.example.service.IBookTypeService;

import java.util.List;

public class BookTypeServiceImpl implements IBookTypeService {

    IBookTypeDao bookTypeDao = new BookTypeDaoImpl();

    @Override
    public List<BookType> getBookTypeList() {

        List<BookType> bookTypes = bookTypeDao.getBookTypeList();

        return bookTypes;
    }

    @Override
    public int addBookType(BookType bookType) {

        int i = bookTypeDao.addBookType(bookType);
        return i;
    }
}
