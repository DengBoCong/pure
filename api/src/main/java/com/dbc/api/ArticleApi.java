package com.dbc.api;

import com.dbc.entity.entity.PureArticleTypeJoinEntity;
import com.dbc.entity.model.ArticleTypeModel;
import com.dbc.service.ArticleTypeService;
import com.dbc.utils.BaseResult;
import com.dbc.condition.ArticleCondition;
import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.entity.entity.PureArticleTypeEntity;
import com.dbc.entity.model.ArticleAddModel;
import com.dbc.service.ArticleService;
import com.dbc.utils.DateUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleApi {
    private static BaseResult<Object> result;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/findArticle")
    public BaseResult<Object> findByCondition(ArticleCondition condition) {

        result.setData(articleService.findAll());
        result.setMsg("这是一条信息");

        return result;
    }

    @ApiOperation(value = "通过文章-分类连表的typeId查询文章，即同一类别的所有文章")
    @PostMapping("/findArticleByTypeId")
    @ApiResponse(code = 0, message = "查询成功")
    public BaseResult<List<PureArticleEntity>> findArticleByTypeId(int typeId) {
        List<PureArticleEntity> list = articleService.findByTypeId(typeId);
        return BaseResult.successWithData(list).setMap("allCount", list.size());
    }

    @PostMapping("/oneInsert")
    public BaseResult<PureArticleEntity> oneInsert(@RequestBody ArticleAddModel articleModel) {
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
