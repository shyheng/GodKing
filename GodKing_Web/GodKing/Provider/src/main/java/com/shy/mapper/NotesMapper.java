package com.shy.mapper;

import com.shy.model.Notes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notes record);

    int insertSelective(Notes record);

    Notes selectByPrimaryKey(Integer id);

    List<Notes> selectNotes();

    int updateByPrimaryKeySelective(Notes record);

    int updateByPrimaryKey(Notes record);
}