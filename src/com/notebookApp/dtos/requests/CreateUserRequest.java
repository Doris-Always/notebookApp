package com.notebookApp.dtos.requests;

import com.notebookApp.data.models.Note;
import lombok.Data;

@Data
public class CreateUserRequest {
    private String userId;
    private String userName;
    private String password;
    private String Email;

}
