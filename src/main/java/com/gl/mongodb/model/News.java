package com.gl.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "News")
public class News {
    @Id
    private String id;
   // @Indexed(unique = true)
    private String URL;
    private String titre;
    private String auteur;
    private Date created;
    private List<Reaction> reactions;
    private List<Comment> comments;
}
