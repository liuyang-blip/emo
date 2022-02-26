package com.emo.mapper;


import com.emo.pojo.Syslog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LogMapper {
    int addLog(Syslog syslog);

    List<Syslog> selectLogInfo(@Param("page")int page, @Param("limit")int limit);

    int showCount();


}
