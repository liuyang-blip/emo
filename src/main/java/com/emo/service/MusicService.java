package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.emo.pojo.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicService {
    //添加音乐
    JSON addMusic(Music music);
    //修改音乐
    JSON updateMusic(Music music);
    //删除音乐
    JSON deleteMusic(int id);
    //查看音乐
    List<Music> selectMusic(int page, int limit,String Keywod);
    //关键字查找
    List<Music> selectWhereMusic();
}
