package com.gl.mongodb.service.Impl;

import com.gl.mongodb.exception.NewsDoesntExisteException;
import com.gl.mongodb.repositoriy.NewsRepository;
import com.gl.mongodb.exception.NewsAlreadyExisteException;
import com.gl.mongodb.model.News;
import com.gl.mongodb.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public News create(News body) throws NewsAlreadyExisteException {
        if(newsRepository.findByUrl (body.getUrl ()))
            throw new NewsAlreadyExisteException ("news with url alerady existe ");
    return newsRepository.save (body);
    }

    @Override
    public News update(News body, Long id) throws NewsAlreadyExisteException, NewsDoesntExisteException {
        if(newsRepository.findByUrl (body.getUrl ()))
            throw new NewsAlreadyExisteException ("news with url alerady existe ");
        News old = this.find (id);
            old.setAuteur (body.getAuteur ());
            old.setId (id);
            old.setTitre (body.getTitre ());
            return newsRepository.save (old);


    }

    @Override
    public void delete(Long id) throws NewsDoesntExisteException {
        News todelete = this.find (id);
        newsRepository.delete (todelete);
    }

    @Override
    public News find(Long id) throws NewsDoesntExisteException {
        return newsRepository.findById (id).orElseThrow (() ->new NewsDoesntExisteException ("news doesnt existe "));
    }

    @Override
    public List<News> fetchAll() {
        return newsRepository.findAll ();
    }
}
