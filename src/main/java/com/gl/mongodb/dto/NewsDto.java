package com.gl.mongodb.dto;

import com.gl.mongodb.model.Comment;
import com.gl.mongodb.model.Reaction;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class NewsDto {
    private String url;
    private String userID;
    private String titre;
    private String auteur;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<Reaction> reactions = new ArrayList<Reaction>();
    private List<Comment> comments = new ArrayList<Comment>();
    private String idUser;
}
