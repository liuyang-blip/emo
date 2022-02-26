package com.emo.mapper;

import com.emo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //登录
    User Login(User user);
    //添加管理员
    int addUser(User user);
    //修改管理员信息
    int updateUser(User user);
    //删除管理员信息
    int deleteUser(@Param("u_id")int u_id);
    //查看管理员信息
    List<User> selectUser(@Param("page")int page,@Param("limit")int limit);
}
