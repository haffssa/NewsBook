package com.gl.mongodb.service.Impl;

import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import com.gl.mongodb.model.News;
import com.gl.mongodb.model.ReactionEnum;
import com.gl.mongodb.repositoriy.NewsRepository;
import com.gl.mongodb.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public News create(News body) throws AllAlreadyExisteException {
        if(newsRepository.existsByUrl (body.getUrl ()))
            throw new AllAlreadyExisteException("news with url already excite ");
    return newsRepository.save (body);
    }

    @Override
    public News update(News body, String id) throws AllAlreadyExisteException, AllDoesntExisteException {
        if(newsRepository.existsByUrl (body.getUrl ()))
            throw new AllAlreadyExisteException("news with url already excite ");
        News old = this.find (id);
            old.setAuteur (body.getAuteur ());
            old.setUserId(body.getUserId());
            old.setId (id);
            old.setTitre (body.getTitre ());
            return newsRepository.save (old);
    }

    @Override
    public void delete(String id) throws AllDoesntExisteException {
        News todelete = this.find (id);
        newsRepository.delete (todelete);
    }

    @Override
    public News find(String id) throws AllDoesntExisteException {
        return newsRepository.findById (id).orElseThrow (() ->new AllDoesntExisteException("news doesn't excite "));
    }

    @Override
    public List<News> fetchAll() {
        return newsRepository.findAll ();
    }

   @Override
    public long getScore(News myNew, ReactionEnum reaction){
        long j =0 ;
        for (int i = 0 ; i < myNew.getReactions ().size ();i++) {
            ReactionEnum reactionEnum = myNew.getReactions ().get (i).getReaction ();
            if (reactionEnum == reaction ) j++ ;
        }
        return j;
    }
}
