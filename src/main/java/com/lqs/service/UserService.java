package com.lqs.service;

import com.lqs.model.Reserve;
import com.lqs.model.User;

import java.util.List;

/**
 * @author lqs
 * @date 2022/3/8 19:46
 */
public interface UserService {
    User login(String username,String password);

    int userRegister(User user);

    int updateUserMsg(User user);

    /**
     * 修改资料
     * @param username
     * @return
     */
    User getUser(String username);

    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    int updatePassword(String username, String password);

    int addReserve(String name, String phone, String address, String datetime, String state);

    List<Reserve> getReserve(String username);

    /**
     * 添加预约信息
     * @param reserve
     * @return
     */
    int addReserve(Reserve reserve);

    int cancelReserve(String reserveId, String state);

    /**
     * 管理员获取全部预约信息
     * @return
     */
    List<Reserve> adminReserve();

    int delReserve(String reserveId);
}
