package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.emo.pojo.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteService {
    //添加树洞小纸条
    JSON addNote(Note note);
    //更改树洞小纸条
    JSON updataNote(Note note);
    //删除树洞小纸条
    JSON deleteNote(int id);
    //查找树洞小纸条
    List<Note> selectNote(int page,int limit);
}
