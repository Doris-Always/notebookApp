package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.data.models.User;
import com.notebookApp.data.repositories.NoteRepository;
import com.notebookApp.data.repositories.UserRepository;
import com.notebookApp.dtos.requests.EditNoteRequest;
import com.notebookApp.dtos.requests.NoteRequest;
import com.notebookApp.dtos.requests.UserRequest;
import com.notebookApp.dtos.responses.NoteResponse;
import com.notebookApp.exceptions.NoteNotFoundException;
import com.notebookApp.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public NoteResponse createNote(String email, NoteRequest noteRequest) {
        User foundUser = userRepository.findByEmail(email);
        NoteResponse noteResponse = new NoteResponse();
        UserRequest userRequest = new UserRequest();
        if (foundUser.getEmail().equals(userRequest.getEmail())) {
            Note note = new Note();
            note.setTopic(noteRequest.getTopic());
            note.setNoteBody(noteRequest.getNoteBody());
            foundUser.setUserId(foundUser.getUserId());
            noteRepository.save(note);
        }else {
            throw new UserNotFoundException("user does not exist,create an account");
        }


        return new NoteResponse("note created successfully",HttpStatus.CREATED);
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
    public Note editNote(String id, EditNoteRequest editNoteRequest) {
        Note foundNote = noteRepository.findNoteByNoteId(id);
        Note note = new Note();
        if (foundNote.equals(note.getNoteId())) {
            foundNote.setTopic(editNoteRequest.getTopic());
            foundNote.setNoteBody(editNoteRequest.getNoteBody());
        }else {
            throw new NoteNotFoundException("no note matches this id");
        }
        return noteRepository.save(foundNote);
    }

    @Override
    public Note addNote(NoteRequest noteRequest) {
//        Note newNote = new Note();
//        List<Note> list = new ArrayList<>();
//        newNote.setNoteBody(noteRequest.getNoteBody());
//        newNote.setTopic(noteRequest.getTopic());
//        newNote.setUserId(noteRequest.getNoteId());
//        list.add(newNote);
//        return noteRepository.save(list);


        Note newNote = new Note();
            newNote.setNoteBody(noteRequest.getNoteBody());
            newNote.setTopic(noteRequest.getTopic());
            newNote.setUserId(noteRequest.getNoteId());
        return noteRepository.save(newNote);
    }
}
