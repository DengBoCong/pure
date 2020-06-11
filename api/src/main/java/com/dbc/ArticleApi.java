package com.dbc;

import com.dbc.Utils.Result;
import com.dbc.condition.ArticleCondition;
import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.entity.model.req.ArticleModel;
import com.dbc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleApi {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/findByCondition")
    public Result<List<PureArticleEntity>> findByCondition(ArticleCondition condition) {
        Result<List<PureArticleEntity>> result = new Result<>();
        result.setData(articleService.findAll());
        result.setMsg("这是一条信息");

        return result;
    }

    @PostMapping("/oneInsert")
    public Result<PureArticleEntity> oneInsert(@RequestBody ArticleModel articleModel) {
        System.out.println(articleModel.getAddTime());
        System.out.println(articleModel.getArticleFlag());
        System.out.println(articleModel.getClasses());
        System.out.println(articleModel.getCommentNum());
        System.out.println(articleModel.getModifyTime());
        System.out.println(articleModel.getPublishTime());
        System.out.println(articleModel.getSubTitle());
        System.out.println(articleModel.getStatus());
        System.out.println(articleModel.getTags().get(0).getContent());
        System.out.println(articleModel.getSummary());
        System.out.println(articleModel.getUserId());
        System.out.println(articleModel.getContent());
        System.out.println(articleModel.getTitle());
        return Result.isOk();
    }
}
