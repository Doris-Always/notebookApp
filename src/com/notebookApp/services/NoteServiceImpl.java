package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.data.repositories.NoteRepository;
import com.notebookApp.dtos.requests.NoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    List<Note> notes = new ArrayList<>();

    @Override
    public void createNote(NoteRequest noteRequest) {
        Note note = new Note();
        note.setTopic(noteRequest.getTopic());
        note.setNoteBody(noteRequest.getNoteBody());
        noteRepository.save(note);
    }

    @Override
    public List<Note> viewAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Note viewById(String id) {
        return noteRepository.findNoteByNoteId(id);
    }

    @Override
    public void deleteById(String id) {
        noteRepository.deleteById(id);

    }

    @Override
    public void editNote(NoteRequest noteRequest) {
        for (Note note : notes){
           note.setTopic(noteRequest.getTopic());
           note.setNoteBody(noteRequest.getNoteBody());
           noteRepository.save(note);
        }
//        Note foundNote = noteRepository.findNoteByNoteId(noteRequest.getNoteId());
//        foundNote.setTopic(noteRequest.getTopic());
//        foundNote.setNoteBody(noteRequest.getNoteBody());
//        return noteRepository.save(foundNote);
//        if (foundNote.equals(noteRequest.getNoteId())){
//            foundNote.setTopic(noteRequest.getTopic());
//        }
//        if (foundNote.equals(noteRequest.getNoteBody())){
//            foundNote.setNoteBody(noteRequest.getNoteBody());
//        }
//
//        return noteRepository.save(foundNote);

    }
}
