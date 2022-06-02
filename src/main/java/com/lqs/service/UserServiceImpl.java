package com.lqs.service;

import com.lqs.dao.UserDao;
import com.lqs.model.Reserve;
import com.lqs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lqs
 * @date 2022/3/8 19:46
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public int userRegister(User user) {
        return userDao.userRegister(user);
    }

    @Override
    public int updateUserMsg(User user) {
        return userDao.updateUserMsg(user);
    }

    @Override
    public User getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public int updatePassword(String username, String password) {
        return userDao.updatePassword(username,password);
    }

    @Override
    public int addReserve(String name, String phone, String address, String datetime, String state) {
        return userDao.addReserve(name,phone,address,datetime,state);
    }

    @Override
    public List<Reserve> getReserve(String username) {
        return userDao.getReserve(username);
    }

    @Override
    public int addReserve(Reserve reserve) {
        return userDao.addReserve(reserve);
    }

    @Override
    public int cancelReserve(String reserveId, String state) {
        return userDao.cancelReserve(reserveId,state);
    }

    @Override
    public List<Reserve> adminReserve() {
        return userDao.adminReserve();
    }

    @Override
    public int delReserve(String reserveId) {
        return userDao.delReserve(reserveId);
    }


}
