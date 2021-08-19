package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.NotesMapper;
import com.shy.model.Notes;
import org.apache.tomcat.util.net.IPv6Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = NotesService.class,version = "1.0.0",timeout = 15000)
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesMapper notesMapper;

    @Override
    public List<Notes> selectNotes() {
        return notesMapper.selectNotes();
    }

    @Override
    public int addNotes(Notes notes) {
        return notesMapper.insert(notes);
    }

    @Override
    public int deleteNotes(int id) {
        return notesMapper.deleteByPrimaryKey(id);
    }
}
