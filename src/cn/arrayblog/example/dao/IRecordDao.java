package cn.arrayblog.example.dao;

import cn.arrayblog.example.domain.Record;

import java.util.List;

public interface IRecordDao {
    int addRecord(int userId,int bookId);
    int removeRecord(int recordId);
    int userRecordNumber(int userId);
    List<Record> getUserRecordList(int userId);
}
