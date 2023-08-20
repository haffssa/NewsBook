package com.gl.mongodb.service;

import com.gl.mongodb.Repositoriy.NewsRepository;
import com.gl.mongodb.exception.NewsAlreadyExisteException;
import com.gl.mongodb.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;
    public List<News> getAll(){
        return newsRepository.findAll();
    }
    public Optional<News> getById(Long id) {
        return  newsRepository.findById(id);

    }
    public News save(News news) throws NewsAlreadyExisteException {
       if(newsRepository.findByUrl(news.getUrl()))
        return newsRepository.save(news);
       else throw new NewsAlreadyExisteException ();
    }
}
