package com.emo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emo.mapper.EmoTextMapper;
import com.emo.pojo.Emotext;
import com.emo.service.EmoTextServiceImpl;
import com.emo.service.EuserServiceImpl;
import com.emo.until.ParseExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RequestMapping("/EmoTextController")
@Controller
public class EmoTextController {
    @Autowired
    private EmoTextServiceImpl emoTextService;


    /**
     * 添加测试题
     * @param emotext
     * @return
     */
    @GetMapping("/addText")
    @ResponseBody
    @CrossOrigin
    public JSON addText(Emotext emotext){
        return emoTextService.addText(emotext);
    }

    /**
     * 修改测试题
     * @param emotext
     * @return
     */
    @GetMapping("/updateText")
    @ResponseBody
    @CrossOrigin
    public JSON updateText(Emotext emotext){
        return emoTextService.updateText(emotext);
    }

    /**
     * 删除测试题
     * @param id
     * @return
     */
    @GetMapping("/deleteText")
    @ResponseBody
    @CrossOrigin
    public JSON deleteText(int id){
        return emoTextService.deleteText(id);
    }

    /**
     * 查看测试题
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectText")
    @ResponseBody
    @CrossOrigin
    public JSON selectText(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1 =page-1;
        int page2 = page1*limit;
        json.put("code",1);
        json.put("msg","查询成功");
        json.put("count",emoTextService.selectText(0,100000).size());
        json.put("data",emoTextService.selectText(page2,limit));
        return json;
    }

    /**
     * 批量添加测试题
     * @param file
     * @return
     */
    @GetMapping("/addAllText")
    @ResponseBody
    @CrossOrigin
    public JSON importAlumnis(MultipartFile file) {
        InputStream inputStream = null;
        //输入流
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        ParseExcel parser = new ParseExcel();
        //第二行开始读取
        int startRow = 1;
        List<String[]> result = null;
        try {
            result = parser.parseExcel(inputStream, suffix, startRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Emotext emotext = new Emotext();
        JSON json = null;
        System.out.println(result);
        for (String[] ss : result) {
            System.out.println(ss);
            emotext.setId(Integer.parseInt(ss[0]));//1
            emotext.setContent(ss[1]);//1
            emotext.setRightanswer(ss[2]);//1
            emotext.setErroranswer(ss[3]);//1
            emotext.setScore((ss[4]));//1
            //导入信息进入数据库
            json = emoTextService.addAllText(emotext);
            System.out.println(json);
            //关闭流
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
