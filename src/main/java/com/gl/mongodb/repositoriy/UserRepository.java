package com.gl.mongodb.repositoriy;

import com.gl.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByAccountName(String accountName);
    Optional<User> findById(String idUser);
}
