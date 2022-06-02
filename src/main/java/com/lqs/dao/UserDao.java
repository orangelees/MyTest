package com.lqs.dao;

import com.lqs.model.Reserve;
import com.lqs.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lqs
 * @date 2022/3/8 19:37
 */
@Mapper
public interface UserDao {

    User login(String username,String password);

    int userRegister(User user);

    int updateUserMsg(User user);

    User getUser(String username);

    int updatePassword(String username, String password);

    int addReserve(String name, String phone, String address, String datetime, String state);

    List<Reserve> getReserve(String username);

    int addReserve(Reserve reserve);

    int cancelReserve(String reserveId, String state);

    List<Reserve> adminReserve();

    int delReserve(String reserveId);
}
