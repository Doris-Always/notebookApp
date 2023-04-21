package com.notebookApp.controllers;

import com.notebookApp.data.models.Note;
import com.notebookApp.data.models.User;
import com.notebookApp.dtos.requests.LoginRequest;
import com.notebookApp.dtos.requests.NoteRequest;
import com.notebookApp.dtos.requests.UserRequest;
import com.notebookApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.register(userRequest),HttpStatus.CREATED);

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> viewAllUsers(){
        return userService.viewAllUser();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> loginUser( @RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>( userService.userLogin(loginRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/addNotesToUser", method = RequestMethod.POST)
    public  ResponseEntity<?> createNotes(@RequestBody NoteRequest request){
        return  new ResponseEntity<>(userService.createNote(request),  HttpStatus.OK);
    }


    @RequestMapping(value = "/viewNotes/{email}",method = RequestMethod.GET)
    public List<Note> viewNotes(@PathVariable("email") String email){
        return userService.viewAllNote(email);
    }
}
