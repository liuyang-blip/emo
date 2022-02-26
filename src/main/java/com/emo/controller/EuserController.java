package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.pojo.Euser;
import com.emo.service.EmotionServiceImpl;
import com.emo.service.EuserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/EuserController")
@Controller
public class EuserController {
    @Autowired
    private EuserServiceImpl euserService;
    /**
     * 添加wx用户
     * @param euser
     * @return
     */
    @GetMapping("/addEuser")
    @ResponseBody
    @CrossOrigin
    public JSON addEuser(Euser euser){
        return euserService.addEuser(euser);
    }
    /**
     * 添加wx用户
     * @param euser
     * @return
     */
    @GetMapping("/updateEuser")
    @ResponseBody
    @CrossOrigin
    public JSON updateEuser(Euser euser){
        return euserService.updateEuser(euser);
    }
    /**
     * 删除wx用户
     * @param e_id
     * @return
     */
    @GetMapping("/deleteEuser")
    @ResponseBody
    @CrossOrigin
    public JSON deleteEuser(int e_id){
        return euserService.deleteEuser(e_id);
    }
    /**
     * 查看wx用户
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectEuser")
    @ResponseBody
    @CrossOrigin
    public JSON selectEuser(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",1);
        json.put("msg","查询成功");
        json.put("count",euserService.selectEuser(0,100000,null).size());
        json.put("data",euserService.selectEuser(page2,limit,null));
        return json;
    }
    /**
     * 关键字查找
     * @param page
     * @param limit
     * @param Keyword
     * @return
     */
    @GetMapping("/selectWhereEuser")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereEuser(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",1);
        json.put("msg","查询成功");
        json.put("count",euserService.selectEuser(0,100000,Keyword).size());
        json.put("data",euserService.selectEuser(page2,limit,Keyword));
        return json;
    }

    /**
     * 通过id查找
     * @param vx_id
     * @return
     */
    @GetMapping("/selectEuserid")
    @ResponseBody
    @CrossOrigin
    public List<Euser> selectEuserid(String vx_id){
        return euserService.selectEuserid(vx_id);
    }
}
