package com.gl.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private String userID;
    private String url;
    private String titre;
    private String auteur;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<Reaction> reactions = new ArrayList<Reaction>();
    private List<Comment> comments = new ArrayList<Comment>();
}
