package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.mapper.EmoTextMapper;
import com.emo.mapper.EuserMapper;
import com.emo.pojo.Emotext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmoTextServiceImpl implements EmoTextService{
    @Autowired
    private EmoTextMapper emoTextMapper;

    @Override
    public JSON addAllText(Emotext emotext) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=emoTextMapper.addAllText(emotext);
            if (code==1){
                json.put("msg","添加成功");
                json.put("code",1);
            }else {
                json.put("msg","添加失败");
                json.put("code",0);
            }

        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }
        return json;
    }

    //添加测试题
    @Override
    public JSON addText(Emotext emotext) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=emoTextMapper.addText(emotext);
            if (code==1){
                json.put("msg","添加成功");
                json.put("code",1);
            }else {
                json.put("msg","添加失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //更改测试题
    @Override
    public JSON updateText(Emotext emotext) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=emoTextMapper.updateText(emotext);
            String answer = emotext.getAnswer();
            if (answer==emotext.getRightanswer()){
                emotext.setScore(emotext.getScore());
            }
            if (code==1){
                json.put("msg","修改成功");
                json.put("code",1);
            }else {
                json.put("msg","修改失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //删除测试题
    @Override
    public JSON deleteText(int id) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=emoTextMapper.deleteText(id);
            if (code==1){
                json.put("msg","删除成功");
                json.put("code",1);
            }else {
                json.put("msg","删除失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //查看测试题
    @Override
    public List<Emotext> selectText(int page, int limit) {
        return emoTextMapper.selectText(page, limit);
    }
}
