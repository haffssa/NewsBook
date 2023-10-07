package com.gl.mongodb.controllers.Impl;

import com.gl.mongodb.controllers.NewsController;
import com.gl.mongodb.dto.NewsDto;
import com.gl.mongodb.exception.AllAlreadyExisteException;
import com.gl.mongodb.exception.AllDoesntExisteException;
import com.gl.mongodb.model.News;
import com.gl.mongodb.model.ReactionEnum;
import com.gl.mongodb.model.User;
import com.gl.mongodb.repositoriy.UserRepository;
import com.gl.mongodb.service.NewsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

@RestController
@RequestMapping("/news")
@AllArgsConstructor
@Slf4j
public class NewsControllerImpl implements NewsController {

    private final NewsService newsService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @PostMapping
    @Override
    public ResponseEntity<News> create(@RequestBody NewsDto body) throws AllAlreadyExisteException, AllDoesntExisteException {
        log.info("NewsController::create request body {}", body);
        News myNews = modelMapper.map (body,News.class);
        User myUser = userRepository.findById(body.getIdUser()).orElseThrow(()->new AllDoesntExisteException("n'exist pas"));
        News myNewNews = newsService.create (myNews);
        myUser.getNews().add(myNewNews);
        userRepository.save(myUser);
        return new ResponseEntity<> (myNewNews, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<News> update(@RequestBody  NewsDto body,@PathVariable String id) throws AllDoesntExisteException, AllAlreadyExisteException {
        log.info("NewsController::update request body {"+body+"} and path variable "+id);
        News myNews = modelMapper.map (body,News.class);
        return new ResponseEntity<>(newsService.update (myNews,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<News> delete(@PathVariable  String id) throws AllDoesntExisteException {
        log.info("NewsController::delete   path variable "+id);
        newsService.delete (id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    @Override
    public ResponseEntity<News> find(@PathVariable String id) throws AllDoesntExisteException {
        log.info("NewsController::find   path variable "+id);
        return new ResponseEntity<>(newsService.find (id), HttpStatus.OK);
    }
    @GetMapping
    @Override
    public ResponseEntity<List<News>> fetchAll() {
        log.info("NewsController::fetchAll ");
        return new ResponseEntity<>(newsService.fetchAll (), HttpStatus.OK);
    }
    @GetMapping("/scores")
    public ResponseEntity<Map<ReactionEnum,LongStream>> getScore(){
        List<News> myNews = newsService.fetchAll ();
        Map<ReactionEnum, LongStream> score  = new HashMap<> ();
        score.put (ReactionEnum.LIKE, LongStream.of (myNews.stream().mapToLong (n->
                        newsService.getScore (n, ReactionEnum.LIKE)
                ).sum ()));
        score.put (ReactionEnum.DISLIKE, LongStream.of (myNews.stream().mapToLong (n->
                newsService.getScore (n, ReactionEnum.DISLIKE)
        ).sum ()));

        return new ResponseEntity<>(score, HttpStatus.OK);
    }


}
