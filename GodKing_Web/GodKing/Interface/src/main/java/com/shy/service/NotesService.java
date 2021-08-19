package com.shy.service;

import com.shy.model.Notes;

import java.util.List;

public interface NotesService {
    List<Notes> selectNotes();
    int addNotes(Notes notes);
    int deleteNotes(int id);
}
