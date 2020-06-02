package com.dbc;

import com.dbc.entity.model.ArticleEntity;
import com.dbc.service.Impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    ArticleServiceImpl articleService;

    @GetMapping("/hello")
    public List<ArticleEntity> hello() {
        return articleService.findAll();
    }
}
