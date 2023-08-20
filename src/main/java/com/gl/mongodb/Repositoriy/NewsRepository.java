package com.gl.mongodb.Repositoriy;

import com.gl.mongodb.model.News;
import org.springframework.data.repository.ListCrudRepository;

public interface NewsRepository extends ListCrudRepository<News, Long> {
}
