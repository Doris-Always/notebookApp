package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.data.models.User;
import com.notebookApp.dtos.requests.LoginRequest;
import com.notebookApp.dtos.requests.NoteRequest;
import com.notebookApp.dtos.requests.UserRequest;
import com.notebookApp.dtos.responses.ApiResponse;
import com.notebookApp.dtos.responses.LoginResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;



public interface UserService extends UserDetailsService {
    User createUser(UserRequest userRequest);

    ApiResponse<User> register(UserRequest userRequest);

    List<User> viewAllUser();
    LoginResponse userLogin( LoginRequest loginRequest);

    void deleteNoteById(String id);
//    Note updateNote();
    List<Note> viewAllNote(String email);

    User createNote(NoteRequest request);


    User findUserByMail(String email);
}
