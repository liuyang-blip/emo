package com.emo.mapper;

import com.emo.pojo.Euser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EuserMapper {
    //添加wx用户
    int addEuser(Euser euser);
    //更改wx用户
    int updateEuser(Euser euser);
    //删除wx用户
    int deleteEuser(@Param("e_id")int e_id);
    //查看wx用户
    List<Euser> selectEuser(@Param("page")int page, @Param("limit")int limit, @Param("Keyword")String Keyword);
    //关键字查看wx用户
    List<Euser> selectWhereEuser();
    //通过id查询
    List<Euser> selectEuserid(@Param("vx_id")String vx_id);
}
