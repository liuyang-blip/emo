package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.pojo.Emotion;
import com.emo.service.EmotionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/EmotionController")
@Controller
@Api(tags = "情绪小妙招管理接口")
public class EmotionController {
    @Autowired
    private EmotionServiceImpl emotionService;

    /**
     * 添加情绪小妙招
     * @param emotion
     * @return
     */
    @GetMapping("/addEmotion")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value ="添加情绪小妙招" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "识别码",required = true,dataType = "int"),
            @ApiImplicitParam(name = "title",value = "标题",required = true,dataType = "String"),
            @ApiImplicitParam(name = "concent",value = "内容",required = true,dataType = "String")
    })
    public JSON addEmotion(Emotion emotion){
        return emotionService.addEmotion(emotion);
    }

    /**
     * 更改情绪小妙招
     * @param emotion
     * @return
     */
    @GetMapping("/updateEmotion")
    @ResponseBody
    @CrossOrigin
    public JSON updateEmotion(Emotion emotion){
        return emotionService.updateEmotion(emotion);
    }

    /**
     * 删除情绪小妙招
     * @param id
     * @return
     */
    @GetMapping("/deleteEmotion")
    @ResponseBody
    @CrossOrigin
    public JSON deleteEmotion(int id){
        return emotionService.deleteEmotion(id);
    }

    /**
     * 查看情绪小妙招
     * @param page
     * @param limit
     //* @param Keyword
     * @return
     */
    @GetMapping("/selectEmotion")
    @ResponseBody
    @CrossOrigin
    public JSON selectEmotion(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",1);
        json.put("msg","查询成功");
        json.put("count",emotionService.selectEmotion(0,100000,null).size());
        json.put("data",emotionService.selectEmotion(page2,limit,null));
        return json;
    }

    /**
     * 关键字查看情绪小妙招
     * @param page
     * @param limit
     * @param Keyword
     * @return
     */
    @GetMapping("/selectWhereEmotion")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereEmotion(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",1);
        json.put("msg","查询成功");
        json.put("count",emotionService.selectEmotion(0,100000,Keyword).size());
        json.put("data",emotionService.selectEmotion(page2,limit,Keyword));
        return json;
    }
}
