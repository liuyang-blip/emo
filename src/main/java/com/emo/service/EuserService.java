package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.emo.pojo.Euser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EuserService {
    //添加wx用户
    JSON addEuser(Euser euser);
    //更改wx用户
    JSON updateEuser(Euser euser);
    //删除wx用户
    JSON deleteEuser(int e_id);
    //查看wx用户
    List<Euser> selectEuser(int page, int limit, String Keyword);
    //关键字查看wx用户
    List<Euser> selectWhereEuser();
    //通过id查询
    List<Euser> selectEuserid(String vx_id);
}
