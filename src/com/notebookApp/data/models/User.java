package com.notebookApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class
User{
    @Id
    private String userId;
    private String userName;
    private String password;
    @Indexed(unique = true)
    private String email;
    //map one-to-many relationship:a user has many notes
    private List<Note> notes = new ArrayList<>();



}