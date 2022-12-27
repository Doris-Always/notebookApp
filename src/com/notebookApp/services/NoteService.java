package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.dtos.requests.CreateNoteRequest;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    void createNote(CreateNoteRequest createNoteRequest);
    List<Note> viewAllNote();
    Optional<Note> viewById(String topic);
    void deleteById(String id);
    void updateNote(CreateNoteRequest createNoteRequest);
}
