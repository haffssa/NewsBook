package com.gl.mongodb.controllers;

import com.gl.mongodb.exception.NewsAlreadyExisteException;
import com.gl.mongodb.dto.NewsDto;
import com.gl.mongodb.model.News;
import com.gl.mongodb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/News")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAll();
    }

    @GetMapping("/{id}")
    public News getNews(@PathVariable Long id){
        Optional<News> thenew = newsService.getById(id);
        News nu=null;
        if (thenew.isPresent()) {
            nu = thenew.get();
        }
        return nu;
    }
    @PostMapping
    public News createNews(@RequestBody NewsDto newsDto) throws NewsAlreadyExisteException {
        News newNews = News.builder().url (newsDto.getURL ())
                .titre (newsDto.getTitre ())
                .auteur (newsDto.getAuteur ())
                .created (newsDto.getCreateanDate ())
                .build ();
        return newsService.save (newNews);
    }
}
