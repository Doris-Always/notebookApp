package com.notebookApp.controllers;

import com.notebookApp.data.models.Note;
import com.notebookApp.dtos.requests.CreateNoteRequest;
import com.notebookApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping("/note")
    public String createNote( @RequestBody CreateNoteRequest createNoteRequest){
        noteService.createNote(createNoteRequest);
        return "note created successfully";
    }
//    @GetMapping("/note/{noteId}")
    @RequestMapping(value = "/note/{noteId}", method = RequestMethod.GET)

    public Note viewById(@PathVariable String noteId){
      return noteService.viewById(noteId);

    }
    @RequestMapping(value = "/note", method = RequestMethod.GET)
    public List<Note> viewAllNote(){
        return noteService.viewAllNote();
    }
    public void deleteById()
}
