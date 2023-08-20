package com.gl.mongodb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NewsDto {
    private String URL;
    private String titre;
    private String auteur;
    private Date createanDate = new Date ();
}
