package com.gl.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "News")
public class News {
    @Id
    private Long id;
   // @Indexed(unique = true)
    private String url;
    private String titre;
    private String auteur;
    private Date created;
    private List<Reaction> reactions;
    private List<Comment> comments;
}
