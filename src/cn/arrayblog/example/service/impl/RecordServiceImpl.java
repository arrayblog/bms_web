package cn.arrayblog.example.service.impl;

import cn.arrayblog.example.dao.IRecordDao;
import cn.arrayblog.example.dao.impl.RecordDaoImpl;
import cn.arrayblog.example.domain.Record;
import cn.arrayblog.example.service.IRecordService;

import java.util.List;

public class RecordServiceImpl implements IRecordService {

    IRecordDao recordDao = new RecordDaoImpl();

    @Override
    public int addRecord(int userId, int bookId) {

        int i = recordDao.addRecord(userId,bookId);

        return i;
    }

    @Override
    public int removeRecord(int recordId) {
        int i = recordDao.removeRecord(recordId);
        return i;
    }

    @Override
    public int userRecordNumber(int userId) {

        int i = recordDao.userRecordNumber(userId);

        return i;
    }

    @Override
    public List<Record> getUserRecordList(int userId) {

        List<Record> records = recordDao.getUserRecordList(userId);

        return records;
    }

}
