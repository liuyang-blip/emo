package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.emo.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    //登录
    JSON Login(User user, HttpSession session);
    //添加管理员
    JSON addUser(User user);
    //修改管理员信息
    JSON updateUser(User user);
    //删除管理员信息
    JSON deleteUser(@Param("u_id")int u_id);
    //查看管理员信息
    List<User> selectUser(@Param("page")int page, @Param("limit")int limit);
}
