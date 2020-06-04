package com.dbc;

import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.service.Impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    ArticleServiceImpl articleService;

    @GetMapping("/hello")
    public List<PureArticleEntity> hello() {
        return articleService.findAll();
    }

    @PostMapping("/insert")
    public Integer insert(PureArticleEntity pureArticleEntity) {
        System.out.println(pureArticleEntity.toString());
        System.out.println(pureArticleEntity.getTitle());
        System.out.println(pureArticleEntity.getSubTitle());
        System.out.println(pureArticleEntity.getContent());
        System.out.println(pureArticleEntity.getAddTime());
        System.out.println(pureArticleEntity.getStatus());
        System.out.println(pureArticleEntity.getSummary());
        System.out.println(pureArticleEntity.getArticleFlag());
        System.out.println(pureArticleEntity.getPublishTime());
        return 0;
    }
}
