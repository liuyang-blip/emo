package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.emo.pojo.Emotion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmotionService {
    //添加情绪小妙招
    JSON addEmotion(Emotion emotion);
    //更改情绪小妙招
    JSON updateEmotion(Emotion emotion);
    //删除情绪小妙招
    JSON deleteEmotion(int id);
    //查看情绪小妙招
    List<Emotion> selectEmotion(int page,int limit,String Keyword);
    //关键字查询
    List<Emotion> selectWhereEmotion();
}
