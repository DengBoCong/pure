package com.dbc;

import com.dbc.entity.Result;
import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.entity.model.req.ArticleModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleApi {
    @PostMapping("/oneInsert")
    public Result<PureArticleEntity> oneInsert(ArticleModel articleModel) {
        System.out.println(articleModel.getAddTime());
        System.out.println(articleModel.getArticleFlag());
        System.out.println(articleModel.getClasses());
        System.out.println(articleModel.getCommentNum());
        System.out.println(articleModel.getModifyTime());
        System.out.println(articleModel.getPublishTime());
        System.out.println(articleModel.getSubTitle());
        System.out.println(articleModel.getStatus());
        System.out.println(articleModel.getTags());
        System.out.println(articleModel.getSummary());
        System.out.println(articleModel.getUserId());
        System.out.println(articleModel.getContent());
        System.out.println(articleModel.getTitle());
        return Result.isOk();
    }
}
