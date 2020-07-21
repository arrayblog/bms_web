package cn.arrayblog.example.service.impl;

import cn.arrayblog.example.dao.IBookDao;
import cn.arrayblog.example.dao.impl.BookDaoImpl;
import cn.arrayblog.example.domain.Book;
import cn.arrayblog.example.domain.User;
import cn.arrayblog.example.service.IBookService;
import cn.arrayblog.example.service.IUserService;

import java.util.List;

public class BookServiceImpl implements IBookService {

    IBookDao bookDao = new BookDaoImpl();


    @Override
    public List getBookList(String keyWord) {

        List<Book> books  = bookDao.getBookList(keyWord);

        return books;
    }

    @Override
    public int addBook(Book book) {

        int i = bookDao.addBook(book);

        return i;
    }

    @Override
    public int updateBook(Book book) {

        int i = bookDao.updateBook(book);

        return i;
    }

    @Override
    public Book findById(int bookId) {

        Book book = bookDao.findById(bookId);

        return book;
    }

    @Override
    public int delBook(int bookId) {

        int i = bookDao.delBook(bookId);

        return i;
    }

    @Override
    public int noExistence(int bookId) {

        int i = bookDao.noExistence(bookId);
        return i;
    }

    @Override
    public int existence(int bookId) {
        int i = bookDao.existence(bookId);
        return i;
    }
}
