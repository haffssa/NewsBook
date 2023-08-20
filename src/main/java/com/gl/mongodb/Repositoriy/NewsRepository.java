package com.gl.mongodb.Repositoriy;

import com.gl.mongodb.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, Long> {
    boolean findByUrl(String url);
}
