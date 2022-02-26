package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.mapper.EuserMapper;
import com.emo.pojo.Euser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EuserServiceImpl implements EuserService{
    @Autowired
    private EuserMapper euserMapper;
    //添加wx用户
    @Override
    public JSON addEuser(Euser euser) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=euserMapper.addEuser(euser);
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
    //更改wx用户
    @Override
    public JSON updateEuser(Euser euser) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=euserMapper.updateEuser(euser);
            if (code==1){
                json.put("msg","更改成功");
                json.put("code",1);
            }else {
                json.put("msg","更改失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //删除wx用户
    @Override
    public JSON deleteEuser(int e_id) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=euserMapper.deleteEuser(e_id);
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
    //查看wx用户
    @Override
    public List<Euser> selectEuser(int page, int limit, String Keyword) {
        return euserMapper.selectEuser(page, limit, Keyword);
    }
    //关键字查看
    @Override
    public List<Euser> selectWhereEuser() {
        return euserMapper.selectWhereEuser();
    }

    @Override
    public List<Euser> selectEuserid(String vx_id) {
        return euserMapper.selectEuserid(vx_id);
    }
}
