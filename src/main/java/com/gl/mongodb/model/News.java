package com.gl.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "News")
public class News {
    @Id
    private String id;
    private String URL;
    private String titre;
    private String auteur;
    private Date created;

    //List<Reaction> reactions;
    //List<Comment> comments;
}
