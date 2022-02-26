package com.emo.mapper;

import com.emo.pojo.Emotion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmotionMapper {
    //添加情绪小妙招
    int addEmotion(Emotion emotion);
    //更改情绪小妙招
    int updateEmotion(Emotion emotion);
    //删除情绪小妙招
    int deleteEmotion(@Param("id")int id);
    //查看情绪小妙招
    List<Emotion> selectEmotion(@Param("page")int page,@Param("limit")int limit,@Param("Keyword")String Keyword);
    //关键字查询
    List<Emotion> selectWhereEmotion();
}
