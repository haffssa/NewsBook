package com.gl.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Comment")
public class Comment {
    @Id
    private String id;
    private String comment;
    private String auteur;
    private LocalDateTime createdAt= LocalDateTime.now();


    public Comment(String comment, String auteur){
        this.comment=comment;
        this.auteur=auteur;
    }
}
