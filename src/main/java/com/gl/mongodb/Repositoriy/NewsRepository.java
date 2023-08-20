package com.gl.mongodb.Repositoriy;

import com.gl.mongodb.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface NewsRepository extends MongoRepository<News, Long> {
}
