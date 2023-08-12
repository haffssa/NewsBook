package com.gl.mongodb.Repositoriy;

import com.gl.mongodb.model.Reaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReactionRepository extends MongoRepository<Reaction, Long> {
}
