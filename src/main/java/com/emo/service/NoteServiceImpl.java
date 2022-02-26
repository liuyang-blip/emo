package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.mapper.NoteMapper;
import com.emo.pojo.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteMapper noteMapper;
    //添加树洞小纸条
    @Override
    public JSON addNote(Note note) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code = noteMapper.addNote(note);
            if (code==1){
                json.put("msg","添加树洞小纸条信息成功");
                json.put("code",1);
            }else {
                json.put("msg","添加树洞小纸条信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试!");
            json.put("code",-1);
        }
        return json;
    }
    //更改树洞小纸条
    @Override
    public JSON updataNote(Note note) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code = noteMapper.updataNote(note);
            if (code==1){
                json.put("msg","更改树洞小纸条信息成功");
                json.put("code",1);
            }else {
                json.put("msg","更改树洞小纸条信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试!");
            json.put("code",-1);
        }
        return json;
    }
    //删除树洞小纸条信息
    @Override
    public JSON deleteNote(int id) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code = noteMapper.deleteNote(id);
            if (code==1){
                json.put("msg","删除树洞小纸条信息成功");
                json.put("code",1);
            }else {
                json.put("msg","删除树洞小纸条信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试!");
            json.put("code",-1);
        }
        return json;
    }
    //查找树洞小纸条信息
    @Override
    public List<Note> selectNote(int page, int limit) {
        return noteMapper.selectNote(page, limit);
    }
}
