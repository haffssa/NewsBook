package com.gl.mongodb.repositoriy;

import com.gl.mongodb.model.Credentiel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentielRepository extends MongoRepository<Credentiel, Long> {
}
