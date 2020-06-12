package com.dbc.api;

import com.dbc.service.ArticleTypeService;
import com.dbc.utils.BaseResult;
import com.dbc.condition.ArticleCondition;
import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.entity.entity.PureArticleTypeEntity;
import com.dbc.entity.model.req.ArticleModel;
import com.dbc.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleApi {
    private static BaseResult<Object> result;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/findArticle")
    public BaseResult<Object> findByCondition(ArticleCondition condition) {

        result.setData(articleService.findAll());
        result.setMsg("这是一条信息");

        return result;
    }

    @PostMapping("/oneInsert")
    public BaseResult<PureArticleEntity> oneInsert(@RequestBody ArticleModel articleModel) {
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
        return BaseResult.success();
    }
}
