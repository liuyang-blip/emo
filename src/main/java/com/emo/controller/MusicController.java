package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.pojo.Music;
import com.emo.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/MusicController")
@Controller
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;

    /**
     * 添加音乐
     * @param music
     * @return
     */
    @GetMapping("/addMusic")
    @ResponseBody
    @CrossOrigin
    public JSON addmusic(Music music){
        return musicService.addMusic(music);
    }

    /**
     * 修改音乐
     * @param music
     * @return
     */
    @GetMapping("/updateMusic")
    @ResponseBody
    @CrossOrigin
    public JSON updateMusic(Music music){
        return musicService.updateMusic(music);
    }

    /**
     * 删除音乐
     * @param id
     * @return
     */
    @GetMapping("/deleteMusic")
    @ResponseBody
    @CrossOrigin
    public JSON deleteMusic(int id){
        return musicService.deleteMusic(id);
    }

    /**
     * 查看音乐
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectMusic")
    @ResponseBody
    @CrossOrigin
    public JSON selectMusic(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2= page1*limit;
        json.put("msg","查询成功");
        json.put("code",1);
        json.put("count",musicService.selectMusic(0,100000,null).size());
        json.put("data",musicService.selectMusic(page2,limit,null));
        return json;
    }
    @GetMapping("/selectWhereMusic")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereMusic(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2= page1*limit;
        json.put("msg","查询成功");
        json.put("code",1);
        json.put("count",musicService.selectMusic(0,100000,Keyword).size());
        json.put("data",musicService.selectMusic(page2,limit,Keyword));
        return json;
    }
}
