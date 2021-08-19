package com.shy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.shy.config.IpUtil;
import com.shy.model.Notes;
import com.shy.service.NotesService;
import com.shy.service.WorkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NotesController {

    @Reference(interfaceClass = NotesService.class, version = "1.0.0", check = false, timeout = 15000)
    private NotesService notesService;

    @RequestMapping("/notes")
    public String notes(){
        Map<String,Object> res = new HashMap<>();
        res.put("flag","yes");
        res.put("notes",notesService.selectNotes());
        return JSON.toJSONString(res);
    }

    @RequestMapping("/add_notes")
    public String addNotes(Notes notes){
        notes.setData(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        notesService.addNotes(notes);
        Map<String,Object> res = new HashMap<>();
        res.put("flg","yes");
        return JSON.toJSONString(res);
    }

    @RequestMapping("/del_notes")
    public String delNotes(int id){
        System.out.println(id);
        notesService.deleteNotes(id);
        Map<String,Object> res = new HashMap<>();
        res.put("flg","yes");
        return JSON.toJSONString(res);
    }
}
