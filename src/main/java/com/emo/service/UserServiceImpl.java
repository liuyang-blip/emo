package com.emo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.mapper.UserMapper;
import com.emo.pojo.User;
import com.emo.until.UntilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public JSON Login(User user, HttpSession session) {
        JSONObject json = new JSONObject();
        user.setPassword(UntilTools.Encrypted_MD5(user.getPassword()));
        User login = userMapper.Login(user);
        if (login!=null){
            login.setPassword("");
            json.put("msg","登录成功");
            json.put("data",login);
            json.put("code",1);
            session.setAttribute("login_session",login);
        }else {
            json.put("msg","登录失败");
            json.put("data",null);
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON addUser(User user) {
        JSONObject json = new JSONObject();
        int code =0;
        user.setPassword(UntilTools.Encrypted_MD5("123456"));
        code =userMapper.addUser(user);
        if (code ==1){
            json.put("msg","添加成功");
            json.put("code",1);
        }else {
            json.put("msg","添加失败");
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON updateUser(User user) {
        JSONObject json = new JSONObject();
        int code = 0;
        code = userMapper.updateUser(user);
        if (code == 1) {
            json.put("msg", "保存成功");
            json.put("code", 1);
        } else {
            json.put("msg", "保存失败");
            json.put("code", 0);

        }
        return json;
    }


    @Override
    public JSON deleteUser(int u_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code =userMapper.deleteUser(u_id);
        if (code ==1){
            json.put("msg","删除成功");
            json.put("code",1);
        }else {
            json.put("msg","删除失败");
            json.put("code",0);
        }
        return json;
    }

    @Override
    public List<User> selectUser(int page, int limit) {
        return userMapper.selectUser(page, limit);
    }
}
