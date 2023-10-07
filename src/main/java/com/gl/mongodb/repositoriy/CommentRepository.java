package com.gl.mongodb.repositoriy;

import com.gl.mongodb.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends MongoRepository<Comment, String>{
}
