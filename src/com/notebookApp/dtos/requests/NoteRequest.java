package com.notebookApp.dtos.requests;

import com.notebookApp.data.models.User;
import lombok.Data;

@Data
public class NoteRequest {
    private String noteId;
    private String topic;
    private String noteBody;
    private String userId;

}
