//package com.notebookApp.services;
//
//import com.notebookApp.Main;
//import com.notebookApp.data.models.Note;
//import com.notebookApp.data.models.User;
//import com.notebookApp.dtos.requests.UserRequest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//
//@SpringBootTest
//public class UserServiceImplTest {
//
//    private User user;
//    private Note note;
//    private UserRequest request;
//
//    @Autowired
//    private  UserService userService;
//
//    @BeforeEach
//    void setUp(){
//        request = new UserRequest();
//        request.setPassword("12345678");
//        request.setUserName("doris");
//        request.setEmail("doris@gmail.com");
//    }
//
//    @Test
//    void testThatNewUserCanBeCreated(){
//        User newUser = userService.createUser(request);
//        var foundUser = userService.findUserByMail(newUser.getEmail());
//        assertNotNull(foundUser);
//    }
//
//}
