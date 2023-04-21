package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.dtos.requests.EditNoteRequest;
import com.notebookApp.dtos.requests.NoteRequest;
import com.notebookApp.dtos.responses.NoteResponse;

import java.util.List;

public interface NoteService {
    NoteResponse createNote(String email, NoteRequest noteRequest);
    List<Note> viewAllNote();
   Note viewById(String id);
    void deleteById(String id);
    Note editNote(String id, EditNoteRequest editNoteRequest);
    Note addNote(NoteRequest noteRequest);
}
