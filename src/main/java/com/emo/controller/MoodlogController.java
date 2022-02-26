package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.pojo.Moodlog;
import com.emo.service.MoodlogService;
import com.emo.service.MoodlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/MoodlogController")
@Controller
public class MoodlogController {
    @Autowired
    private MoodlogServiceImpl moodlogService;

    /**
     * 添加心情信息
     * @param moodlog
     * @return
     */
    @GetMapping("/addMoodlog")
    @ResponseBody
    @CrossOrigin
    public JSON addMoodlog(Moodlog moodlog){
        return moodlogService.addMoodlog(moodlog);
    }

    /**
     * 更改心情信息
     * @param moodlog
     * @return
     */
    @GetMapping("/updataMoodlog")
    @ResponseBody
    @CrossOrigin
    public JSON updataMoodlog(Moodlog moodlog){
        return moodlogService.updataMoodlog(moodlog);
    }

    /**
     * 删除心情信息
     * @param id
     * @return
     */
    @GetMapping("/deleteMoodlog")
    @ResponseBody
    @CrossOrigin
    public JSON deleteMoodlog(int id){
        return moodlogService.deleteMoodlod(id);
    }

    /**
     * 删除心情信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectMoodlog")
    @ResponseBody
    @CrossOrigin
    public JSON selectMoodlog(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        try {
            int page1=page-1;
            int page2=page1*limit;
            json.put("code", 1);
            json.put("msg", "查询信息成功");
            json.put("count", moodlogService.selectMoodlog(0, 100000).size());
            json.put("data", moodlogService.selectMoodlog(page2, limit));
        }catch (Exception e){
            e.printStackTrace();
            json.put("code", -1);
            json.put("msg", "数据接口异常,请稍后再试");
        }
        return json;
    }
}
