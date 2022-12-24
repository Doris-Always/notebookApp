package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.dtos.requests.CreateNoteRequest;
import org.springframework.stereotype.Service;

import java.util.List;
public interface NoteService {
    void createNote(CreateNoteRequest createNoteRequest);
    List<Note> viewAllNote();
    String viewById(String topic);
    void deleteById(String id);
    void updateNote(CreateNoteRequest createNoteRequest);
}
