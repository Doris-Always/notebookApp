package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.dtos.requests.CreateNoteRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService{
    @Override
    public void createNote(CreateNoteRequest createNoteRequest) {

    }

    @Override
    public List<Note> viewAllNote() {
        return null;
    }

    @Override
    public String viewById(String topic) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void updateNote(CreateNoteRequest createNoteRequest) {

    }
}
