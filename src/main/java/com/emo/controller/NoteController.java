package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.pojo.Note;
import com.emo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/NoteController")
@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * 添加树洞小纸条信息
     * @param note
     * @return
     */
    @GetMapping("/addNote")
    @ResponseBody
    @CrossOrigin
    public JSON addNote(Note note){
        return noteService.addNote(note);
    }

    /**
     * 更改树洞小纸条信息
     * @param note
     * @return
     */
    @GetMapping("/updataNote")
    @ResponseBody
    @CrossOrigin
    public JSON updataNote(Note note){
        return noteService.updataNote(note);
    }

    /**
     * 删除树洞小纸条信息
     * @param id
     * @return
     */
    @GetMapping("/deleteNote")
    @ResponseBody
    @CrossOrigin
    public JSON deleteNote(int id){
        return noteService.deleteNote(id);
    }

    /**
     * 查找树洞小纸条信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectNote")
    @ResponseBody
    @CrossOrigin
    public JSON selectNote(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1= page-1;
        int page2=page1*limit;
        json.put("code",1);
        json.put("msg","查询树洞小纸条信息成功");
        json.put("count",noteService.selectNote(0,100000).size());
        json.put("data",noteService.selectNote(page2, limit));
        return json;
    }
}
