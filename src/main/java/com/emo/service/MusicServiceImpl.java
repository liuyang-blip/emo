package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.mapper.MusicMapper;
import com.emo.pojo.Music;
import com.emo.until.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService{
    @Autowired
    private MusicMapper musicMapper;
    //添加音乐
    @Override
    public JSON addMusic(Music music) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code=musicMapper.addMusic(music);
            if (code==1){
                json.put("msg","添加成功");
                json.put("code",1);
            }else {
                json.put("msg","添加失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //修改音乐
    @Override
    public JSON updateMusic(Music music) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code=musicMapper.updateMusic(music);
            if (code==1){
                json.put("msg","修改成功");
                json.put("code",1);
            }else {
                json.put("msg","修改失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //删除音乐
    @Override
    public JSON deleteMusic(int id) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code=musicMapper.deleteMusic(id);
            if (code==1){
                json.put("msg","删除成功");
                json.put("code",1);
            }else {
                json.put("msg","删除失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //查看音乐
    @Override
    public List<Music> selectMusic(int page, int limit, String Keywod) {
        return musicMapper.selectMusic(page, limit, Keywod);
    }
    //关键字查看音乐
    @Override
    public List<Music> selectWhereMusic() {
        return musicMapper.selectWhereMusic();
    }
}
