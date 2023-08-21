package com.gl.mongodb.controllers;


import com.gl.mongodb.dto.NewsDto;
import com.gl.mongodb.model.News;


public interface NewsController extends  IcrudController<NewsDto,Long, News>{
}
