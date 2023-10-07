package com.gl.mongodb.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private String id;
    private String comment;
    private String auteur;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String idNews;
}
