package com.notebookApp.data.models;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Note {
    @Id
    private String noteId;
    private String userId;
    private String topic;
    private String noteBody;
    private LocalDateTime creationTime = LocalDateTime.now();



}
