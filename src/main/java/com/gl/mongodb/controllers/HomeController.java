package com.gl.mongodb.controllers;

import com.gl.mongodb.model.News;
import com.gl.mongodb.service.Impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@Controller
public class HomeController {
    @Autowired
    private NewsServiceImpl newsServiceImpl;
    @GetMapping("/")
    public String root(Model model){
        List<News> news = newsServiceImpl.fetchAll();
        model.addAttribute("news",news);
        return "index";
    }
}
