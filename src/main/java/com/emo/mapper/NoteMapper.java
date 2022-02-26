package com.emo.mapper;

import com.emo.pojo.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoteMapper {
    //添加树洞小纸条
    int addNote(Note note);
    //更改树洞小纸条
    int updataNote(Note note);
    //删除树洞小纸条
    int deleteNote(@Param("id")int id);
    //查找树洞小纸条
    List<Note> selectNote(@Param("page")int page,@Param("limit")int limit);
}
