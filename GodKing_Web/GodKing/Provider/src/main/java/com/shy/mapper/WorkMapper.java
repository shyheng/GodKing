package com.shy.mapper;

import com.shy.model.Work;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    List<Work> selectWork();

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}