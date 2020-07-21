package cn.arrayblog.example.test;

import cn.arrayblog.example.dao.impl.BasicDaoImpl;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class DaoTest {

    @Test
    // 通过删除操作对数据库内容进行更改
    // 返回更改条目为1，说明数据库连接成功
    // 该操作说明BaseDao内的BaseDao方法是正确的

    public void baseDaoTest(){
        int num = BasicDaoImpl.executeSql("delete from user where id =4",null);
        System.out.println(num);
    }

    @Test
    public void dateTest(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH,1);
        System.out.println(new Date());
        System.out.println(c.getTime());
    }

    @Test
    public void dateTest2(){
        System.out.println(String.valueOf(new Date()));
    }

}

