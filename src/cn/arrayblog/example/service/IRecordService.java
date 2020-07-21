package cn.arrayblog.example.service;

import cn.arrayblog.example.domain.Record;

import java.util.List;

public interface IRecordService {
    int addRecord(int userId,int bookId);
    int removeRecord(int recordId);
    int userRecordNumber(int userId);
    List<Record> getUserRecordList(int userId);
}
