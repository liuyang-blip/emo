package com.emo.mapper;

import com.emo.pojo.Emotext;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@Repository
public interface EmoTextMapper {
    //批量添加测试题
    int addAllText(Emotext emotext);
    //添加测试题
    int addText(Emotext emotext);
    //更改测试题
    int updateText(Emotext emotext);
    //删除测试题
    int deleteText(@Param("id")int id);
    //查看测试题
    List<Emotext> selectText(@Param("page")int page,@Param("limit")int limit);
}
