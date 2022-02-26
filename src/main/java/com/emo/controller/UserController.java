package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.pojo.User;
import com.emo.service.UserServiceImpl;
import com.emo.until.aLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/UserController")
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    /**
     * 添加用户
     *
     * @param user 实体类
     * @return
     */
    @GetMapping("/addUser")
    @ResponseBody
    @CrossOrigin
    public JSON addUser(User user) {
        return userService.addUser(user);
    }
    /**
     * 删除用户
     *
     * @param u_id
     * @return
     */
    @GetMapping("/deleteUser")
    @ResponseBody
    @CrossOrigin
    public JSON deleteUser(int u_id) {
        return userService.deleteUser(u_id);
    }

    /**
     * 修改管理员信息
     * @param user
     * @return
     */
    @GetMapping("/updataUser")
    @ResponseBody
    @CrossOrigin
    public JSON updataUser(User user){
        return userService.updateUser(user);
    }
    @GetMapping("/selectUser")
    @ResponseBody
    @CrossOrigin
    public JSON selectUser(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        try {
            int page1=page-1;
            int page2=page1*limit;
            json.put("code", 1);
            json.put("msg", "查询信息成功");
            json.put("count", userService.selectUser(0, 100000).size());
            json.put("data", userService.selectUser(page2, limit));
        }catch (Exception e){
            e.printStackTrace();
            json.put("code", -1);
            json.put("msg", "数据接口异常,请稍后再试");
        }
        return json;
    }
}

