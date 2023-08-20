package com.gl.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Reaction")
public class Reaction {
    @Id
    private String  id;
    private String auteur;
    private String createdAt;
    private ReactionEnum recation;
}
