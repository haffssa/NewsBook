package com.gl.mongodb.controllers;


import com.gl.mongodb.dto.ReactionDto;
import com.gl.mongodb.model.Reaction;

import com.gl.mongodb.repositoriy.ReactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Reaction")
@AllArgsConstructor
public class ReactionController {
    private final ReactionRepository reactionRepository;

    @PostMapping
    public Reaction create(@RequestBody ReactionDto reactionDto) {
        Reaction reaction = new Reaction(reactionDto.getAuteur(), reactionDto.getReaction());
        return reactionRepository.save (reaction);
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
