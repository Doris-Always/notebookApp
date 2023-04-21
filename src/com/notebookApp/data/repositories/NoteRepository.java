package com.notebookApp.data.repositories;

import com.notebookApp.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note,String> {
    Note findNoteByNoteId(String id);
}
