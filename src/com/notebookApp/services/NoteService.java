package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.dtos.requests.NoteRequest;

import java.util.List;

public interface NoteService {
    void createNote(NoteRequest noteRequest);
    List<Note> viewAllNote();
   Note viewById(String id);
    void deleteById(String id);
    void editNote(NoteRequest noteRequest);
}
