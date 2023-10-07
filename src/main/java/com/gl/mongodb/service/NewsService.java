package com.gl.mongodb.service;

import com.gl.mongodb.model.News;
import com.gl.mongodb.model.ReactionEnum;

public interface NewsService extends IcrudService<News>{
    long getScore(News myNew, ReactionEnum reaction);
}
