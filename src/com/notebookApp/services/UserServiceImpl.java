package com.notebookApp.services;

import com.notebookApp.data.models.Note;
import com.notebookApp.data.models.User;
import com.notebookApp.data.repositories.NoteRepository;
import com.notebookApp.data.repositories.UserRepository;
import com.notebookApp.dtos.requests.LoginRequest;
import com.notebookApp.dtos.requests.NoteRequest;
import com.notebookApp.dtos.requests.UserRequest;
import com.notebookApp.dtos.responses.ApiResponse;
import com.notebookApp.dtos.responses.LoginResponse;
import com.notebookApp.exceptions.NoteNotFoundException;
import com.notebookApp.exceptions.UserNotFoundException;
import com.notebookApp.exceptions.UserRegisterationException;
import com.notebookApp.utils.validators.UserDetailValidator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteService noteService;

  @Autowired
  @Lazy
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NoteRepository noteRepository;



    @Override
    public User createUser(UserRequest userRequest) {
        Optional<User> foundUser = Optional.ofNullable(userRepository.findByEmail(userRequest.getEmail()));
        if (foundUser.isPresent()){
            throw new UserRegisterationException("User already exist");
        }
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
         return userRepository.save(user);

    }
    public ApiResponse <User>register(UserRequest userRequest){

        if (!UserDetailValidator.isValidUserName(userRequest.getUserName()))
            throw new UserRegisterationException(String
                    .format("user %s is not valid",userRequest.getUserName()));
        if (!UserDetailValidator.isValidEmail(userRequest.getEmail()))
            throw new UserRegisterationException(String
                    .format("email %s is invalid,enter a valid email",userRequest.getEmail()));
        userRequest.setPassword(userRequest.getPassword());

        User newUser = createUser(userRequest);
        userRepository.save(newUser);

        return new ApiResponse<>("user registered successfully", LocalDateTime.now());
    }

    @Override
    public List<User> viewAllUser() {
        return userRepository.findAll();
    }

    @Override
    public LoginResponse userLogin( LoginRequest loginRequest) {
        User foundUser = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        if (foundUser.getPassword().equals(loginRequest.getPassword())){
            loginResponse.setMessage("login successful");
            loginResponse.setHttpStatus(HttpStatus.OK);
        }else {
            throw new UserNotFoundException("user needs to register first");
        }

        return loginResponse;
    }

    @Override
    public void deleteNoteById(String id) {
        Note foundNote = noteRepository.findNoteByNoteId(id);
        if (foundNote!= null)  noteService.deleteById(id);


    }

    @Override
    public List<Note> viewAllNote(String email) {
        if (noteService.viewAllNote().isEmpty()) throw new NoteNotFoundException("no note found for the user");
        else  return noteService.viewAllNote();

    }

    @Override
    public User findUserByMail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createNote(NoteRequest request){
        Note note = noteService.addNote(request);
         Note isExist = noteRepository.findNoteByNoteId(request.getNoteId());
        User finduser = userRepository.findUserByUserId(request.getUserId());
        finduser.getNotes().add(note);
        userRepository.save(finduser);
        return finduser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException,ClassCastException {
        User user =userRepository.findByEmail(email);
        if (user.getEmail().isEmpty()){
            throw new UsernameNotFoundException(String.format("User not found",email));
        }
     return (UserDetails) user;

    }
}
