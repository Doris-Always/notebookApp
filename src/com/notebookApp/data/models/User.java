package com.notebookApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;

    private List<Note> notes = new ArrayList<>();


}
