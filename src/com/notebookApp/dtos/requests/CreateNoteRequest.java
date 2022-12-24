package com.notebookApp.dtos.requests;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CreateNoteRequest {
    private String noteId;
    private String topic;
    private String noteBody;

}
