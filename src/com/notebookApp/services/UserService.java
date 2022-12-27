package com.notebookApp.services;

import com.notebookApp.dtos.requests.CreateUserRequest;

public interface UserService {
    void createUser(CreateUserRequest createUserRequest);
    void viewUserDetail(String userName);
}
