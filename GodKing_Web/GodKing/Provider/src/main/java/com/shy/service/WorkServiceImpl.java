package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.WorkMapper;
import com.shy.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = WorkService.class,version = "1.0.0",timeout = 15000)
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    public List<Work> selectWork() {
        return workMapper.selectWork();
    }

    @Override
    public int upWork(Work work) {
        return workMapper.updateByPrimaryKey(work);
    }
}
