package com.gl.mongodb.Repositoriy;

import com.gl.mongodb.model.Credentiel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CredentielRepository extends MongoRepository<Credentiel, Long> {
}
