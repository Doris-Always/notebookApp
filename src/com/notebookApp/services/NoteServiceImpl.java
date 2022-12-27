package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.data.repositories.NoteRepository;
import com.notebookApp.dtos.requests.CreateNoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
   private NoteRepository noteRepository;

    @Override
    public void createNote(CreateNoteRequest createNoteRequest) {
        Note note = new Note();
        note.setTopic(createNoteRequest.getTopic());
        note.setNoteBody(createNoteRequest.getNoteBody());
        noteRepository.save(note);
    }

    @Override
    public List<Note> viewAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> viewById(String Id) {
        return noteRepository.findById(Id);
    }

    @Override
    public void deleteById(String id) {
        noteRepository.deleteById(id);

    }

    @Override
    public void updateNote(CreateNoteRequest createNoteRequest) {
        Note note = new Note();
        note.setNoteId(note.getNoteId());
        note.setTopic(createNoteRequest.getTopic());
        note.setNoteBody(createNoteRequest.getNoteBody());
        noteRepository.save(note);

    }
}
