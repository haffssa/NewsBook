package com.gl.mongodb.dto;

import com.gl.mongodb.model.ReactionEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReactionDto {
    private String  id;
    private String auteur;
    private ReactionEnum reaction;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String idNews;
}
