package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.emo.pojo.Emotext;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmoTextService {
    //批量添加
    JSON addAllText(Emotext emotext);
    //添加测试题
    JSON addText(Emotext emotext);
    //更改测试题
    JSON updateText(Emotext emotext);
    //删除测试题
    JSON deleteText(int id);
    //查看测试题
    List<Emotext> selectText(int page, int limit);
}
