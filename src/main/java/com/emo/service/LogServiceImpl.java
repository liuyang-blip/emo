package com.emo.service;


import com.emo.mapper.LogMapper;
import com.emo.pojo.Syslog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int addLog(Syslog syslog) {
        return logMapper.addLog(syslog);
    }

    @Override
    public List<Syslog> selectLogInfo(int page, int limit) {
        return logMapper.selectLogInfo(page, limit);
    }


}
