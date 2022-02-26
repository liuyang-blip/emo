package com.emo.mapper;

import com.emo.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MusicMapper {
    //添加音乐
    int addMusic(Music music);
    //修改音乐
    int updateMusic(Music music);
    //删除音乐
    int deleteMusic(@Param("id")int id);
    //查看音乐
    List<Music> selectMusic(@Param("page")int page,@Param("limit")int limit,@Param("Keyword")String Keywod);
    //关键字查找
    List<Music> selectWhereMusic();
}
