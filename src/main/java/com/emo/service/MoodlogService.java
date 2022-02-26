package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.emo.pojo.Moodlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoodlogService {
    //添加心情记录
    JSON addMoodlog(Moodlog moodlog);
    //更改心情记录
    JSON updataMoodlog(Moodlog moodlog);
    //删除心情记录
    JSON deleteMoodlod(int id);
    //查看心情记录
    List<Moodlog> selectMoodlog(int page,int limit);
}
