package com.emo.mapper;

import com.emo.pojo.Moodlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MoodlogMapper {
    //添加心情记录
    int addMoodlog(Moodlog moodlog);
    //更改心情记录
    int updataMoodlog(Moodlog moodlog);
    //删除心情记录
    int deleteMoodlod(@Param("id")int id);
    //查看心情记录
    List<Moodlog> selectMoodlog(@Param("page")int page,@Param("limit")int limit);
}
