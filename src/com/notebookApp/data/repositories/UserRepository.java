package com.notebookApp.data.repositories;

import com.notebookApp.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findUserByUserId(String id);
     User findByEmail(String email);
}
