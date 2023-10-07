package com.gl.mongodb.dto;

import com.gl.mongodb.model.Credentiel;
import com.gl.mongodb.model.News;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    private String id;
    private String accountName;
    private Credentiel account ;
    private List<News> news = new ArrayList<>();

}
