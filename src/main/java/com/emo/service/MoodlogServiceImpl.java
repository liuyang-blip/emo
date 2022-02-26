package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.mapper.MoodlogMapper;
import com.emo.pojo.Moodlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MoodlogServiceImpl implements MoodlogService{
    @Autowired
    private MoodlogMapper moodlogMapper;
    //添加心情信息
    @Override
    public JSON addMoodlog(Moodlog moodlog) {
        JSONObject json = new JSONObject();
        try {
            Date time = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
            moodlog.setAddtime(current);
            int code = 0;
            code = moodlogMapper.addMoodlog(moodlog);
            if (code==1){
                json.put("msg","添加心情信息成功");
                json.put("code",1);
            }else {
                json.put("msg","添加心情信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }

        return json;
    }
    //更改心情信息
    @Override
    public JSON updataMoodlog(Moodlog moodlog) {
        JSONObject json = new JSONObject();
        Moodlog moodlog1 = new Moodlog();
        try {
            Date time = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
            moodlog.setAddtime(current);
            int code = 0;
            code = moodlogMapper.updataMoodlog(moodlog);

            if (code==1){
                json.put("msg","更改心情信息成功");
                json.put("code",1);
            }else {
                json.put("msg","更改心情信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }

        return json;
    }
    //删除心情信息
    @Override
    public JSON deleteMoodlod(int id) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = moodlogMapper.deleteMoodlod(id);
            if (code==1){
                json.put("msg","删除心情信息成功");
                json.put("code",1);
            }else {
                json.put("msg","删除心情信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }

        return json;
    }
    //查找心情信息
    @Override
    public List<Moodlog> selectMoodlog(int page, int limit) {
        return moodlogMapper.selectMoodlog(page, limit);
    }
}
