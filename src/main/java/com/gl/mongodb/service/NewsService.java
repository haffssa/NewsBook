package com.gl.mongodb.service;

import com.gl.mongodb.Repositoriy.NewsRepository;
import com.gl.mongodb.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
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
    public News save(News news){
        if  (news.getId() == null){
            news.setCreated(LocalDateTime.now());
        }
        news.setUpdated(LocalDateTime.now());
        return newsRepository.save(news);
    }
}
