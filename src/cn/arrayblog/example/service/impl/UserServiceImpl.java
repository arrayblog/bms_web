package cn.arrayblog.example.service.impl;

import cn.arrayblog.example.dao.IUserDao;
import cn.arrayblog.example.dao.impl.UserDaoImpl;
import cn.arrayblog.example.domain.User;
import cn.arrayblog.example.service.IUserService;

public class UserServiceImpl implements IUserService {

    IUserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {

        User activeUser = userDao.login(user);

        return activeUser;
    }

}
