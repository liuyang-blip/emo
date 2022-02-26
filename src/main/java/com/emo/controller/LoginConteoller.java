package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.pojo.User;
import com.emo.service.UserServiceImpl;
import com.emo.until.qiniu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("Login")
@Controller
public class LoginConteoller {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取凭证
     * @return
     */
    @GetMapping("/getVoucher")
    @ResponseBody
    @CrossOrigin
    public JSON getVoucher(){
        JSONObject json = new JSONObject();
        qiniu qiniu = new qiniu();
        json.put("code",1);
        json.put("msg","获取凭证成功");
        json.put("data",qiniu.File());
        return json;
    }
    /**
     * 登录+
     //     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    public JSON login(String username, String password, HttpSession session){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.Login(user,session);
    }
//    @aLog(value = "session缓存")
    /**
     * 从session中获取登录状态
     * @param session
     * @param key
     * @return
     */
    @PostMapping("/session")
    @ResponseBody
    @CrossOrigin
    public Object session(HttpSession session,String key){
        return session.getAttribute(key);
    }
}
