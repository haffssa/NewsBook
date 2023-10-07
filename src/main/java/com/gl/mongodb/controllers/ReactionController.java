package com.gl.mongodb.controllers;


import com.gl.mongodb.dto.ReactionDto;
import com.gl.mongodb.exception.AllDoesntExisteException;
import com.gl.mongodb.model.News;
import com.gl.mongodb.model.Reaction;

import com.gl.mongodb.repositoriy.NewsRepository;
import com.gl.mongodb.repositoriy.ReactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Reaction")
@AllArgsConstructor
public class ReactionController {
    private final ReactionRepository reactionRepository;
    private final NewsRepository newsRepository;
    @PostMapping
    public ResponseEntity<Reaction> create(@RequestBody ReactionDto reactionDto) throws AllDoesntExisteException {
        News myNew = newsRepository.findById(reactionDto.getIdNews()).orElseThrow(()->new AllDoesntExisteException ("n'exist pas"));
        Reaction reaction = new Reaction(reactionDto.getAuteur(), reactionDto.getReaction());
        Reaction myNewReaction = reactionRepository.save (reaction);
        myNew.getReactions ().add (myNewReaction);
        newsRepository.save (myNew);
        return new ResponseEntity<> (myNewReaction, HttpStatus.OK);
    }
    @GetMapping
    public List<Reaction> getAll(){
        return reactionRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Reaction> findOne(@PathVariable String id){
        return reactionRepository.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        reactionRepository.deleteById(id);
    }
}
