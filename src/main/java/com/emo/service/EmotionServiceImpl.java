package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.emo.mapper.EmotionMapper;
import com.emo.pojo.Emotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmotionServiceImpl implements  EmotionService{
    @Autowired
    private EmotionMapper emotionMapper;
    //添加情绪小妙招信息
    @Override
    public JSON addEmotion(Emotion emotion) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=emotionMapper.addEmotion(emotion);
            if (code==1){
                json.put("msg","添加情绪小妙招信息成功");
                json.put("code",1);
            }else {
                json.put("msg","添加情绪小妙招信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试！");
            json.put("code",-1);
        }
        return json;
    }
    //更改情绪小妙招信息
    @Override
    public JSON updateEmotion(Emotion emotion) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=emotionMapper.updateEmotion(emotion);
            if (code==1){
                json.put("msg","更改情绪小妙招信息成功");
                json.put("code",1);
            }else {
                json.put("msg","更改情绪小妙招信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试！");
            json.put("code",-1);
        }
        return json;
    }
    //删除情绪小妙招信息
    @Override
    public JSON deleteEmotion(int id) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=emotionMapper.deleteEmotion(id);
            if (code==1){
                json.put("msg","删除情绪小妙招信息成功");
                json.put("code",1);
            }else {
                json.put("msg","删除情绪小妙招信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试！");
            json.put("code",-1);
        }
        return json;
    }
    //查看情绪小妙招
    @Override
    public List<Emotion> selectEmotion(int page, int limit, String Keyword) {
        return emotionMapper.selectEmotion(page, limit,null);
    }
    //关键字查看情绪小妙招
    @Override
    public List<Emotion> selectWhereEmotion() {
        return emotionMapper.selectWhereEmotion();
    }
}
