package com.gl.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "News")
public class News {
    @Id
    private long id;
    private String URL;
    private String titre;
    private String auteur;
    private LocalDateTime created;
    private LocalDateTime updated;

    //List<Reaction> reactions;
    //List<Comment> comments;

    public News(String URL,String titre,String auteur,LocalDateTime created,LocalDateTime updated){
        this.URL=URL;
        this.titre=titre;
        this.auteur=auteur;
        this.created=created;
        this.updated=updated;
    }
}
