package com.dbc.api;

import com.dbc.entity.entity.PureArticleTagEntity;
import com.dbc.entity.entity.PureArticleTypeJoinEntity;
import com.dbc.service.ArticleTagService;
import com.dbc.service.ArticleTypeJoinService;
import com.dbc.service.ArticleTypeService;
import com.dbc.utils.BaseResult;
import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.entity.entity.PureArticleTypeEntity;
import com.dbc.entity.model.ArticleAddModel;
import com.dbc.service.ArticleService;
import com.dbc.service.utils.DateUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleApi {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTypeJoinService articleTypeJoinService;

    @Autowired
    private ArticleTagService articleTagService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @ApiOperation(value = "通过文章-分类连表的typeId查询文章，即同一类别的所有文章")
    @PostMapping("/findArticleByTypeId")
    @ApiResponse(code = 0, message = "查询成功")
    public BaseResult<List<ArticleAddModel>> findArticleByTypeId(int typeId) {
        ArticleAddModel articleAddModel = null;
        List<PureArticleEntity> list = articleService.findByTypeId(typeId);
        List<ArticleAddModel> resultList = new ArrayList<>();
        for (PureArticleEntity articleEntity : list) {
            articleAddModel = new ArticleAddModel();
            articleAddModel.setArticleEntity(articleEntity);
            articleAddModel.setTags(articleTagService.findAllByArticleId(articleEntity.getId()));
            resultList.add(articleAddModel);
        }
        return BaseResult.successWithData(resultList).setMap(list.size());
    }

    @ApiOperation(value = "通过文章ID进行查询")
    @GetMapping("/findByArticleId")
    @ApiResponse(code = 0, message = "查询成功")
    public BaseResult<ArticleAddModel> findArticleByArticleId(int articleId) {
        ArticleAddModel articleAddModel = new ArticleAddModel();
        articleAddModel.setArticleEntity(articleService.findById(articleId));
        articleAddModel.setTags(articleTagService.findAllByArticleId(articleId));
        return BaseResult.successWithData(articleAddModel);
    }

    @ApiOperation(value = "通过文章相关信息进行添加文章接口")
    @PutMapping("/oneInsert")
    @ApiResponse(code = 0, message = "添加成功")
    public BaseResult<PureArticleEntity> oneInsert(@RequestBody ArticleAddModel articleModel) {
        PureArticleEntity articleEntity = articleService.addOneEntity(articleModel.getArticleEntity());
        List<PureArticleTypeJoinEntity> articleTypeJoinEntities = new ArrayList<>();
        PureArticleTypeJoinEntity articleTypeJoinEntity = null;
        for (PureArticleTypeEntity articleTypeEntity : articleModel.getClasses()) {
            articleTypeJoinEntity = new PureArticleTypeJoinEntity();
            articleTypeJoinEntity.setTypeId(articleTypeEntity.getId());
            articleTypeJoinEntity.setArticleId(articleEntity.getId());
            articleTypeJoinEntity.setAddTime(DateUtils.NewDateInt());
            articleTypeJoinEntities.add(articleTypeJoinEntity);
        }
        articleTypeJoinService.allInsert(articleTypeJoinEntities);

        List<PureArticleTagEntity> articleTagEntities = new ArrayList<>();
        PureArticleTagEntity tmp = null;
        for (PureArticleTagEntity articleTagEntity : articleModel.getTags()) {
            tmp = new PureArticleTagEntity();
            tmp.setAddTime(DateUtils.NewDateInt());
            tmp.setArticleId(articleEntity.getId());
            tmp.setContent(articleTagEntity.getContent());
            articleTagEntities.add(tmp);
        }
        articleTagService.allInsert(articleTagEntities);

        return BaseResult.success();
    }
}
