package com.dbc.api;

import com.dbc.entity.entity.PureArticleTypeEntity;
import com.dbc.service.ArticleTypeService;
import com.dbc.utils.BaseResult;
import com.dbc.utils.DateUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articleType")
public class ArticleTypeApi {
    @Autowired
    private ArticleTypeService articleTypeService;

    @ApiOperation(value = "获取全部的文章类别")
    @GetMapping("/findType")
    @ApiResponses(value = {@ApiResponse(code = 1001, message = "成功"), @ApiResponse(code = 1002, message = "失败")})
    public BaseResult<List<PureArticleTypeEntity>> findArticleType() {
        List<PureArticleTypeEntity> dataList = articleTypeService.findAll();
        return BaseResult.successWithData(dataList);
    }

    @ApiOperation(value = "文章分类专栏添加接口")
    @PostMapping("/oneInsert")
    public BaseResult oneInsert(@RequestBody PureArticleTypeEntity articleTypeEntity) {
        articleTypeEntity.setAddTime(DateUtils.NewDateInt());
        articleTypeEntity.setFontCover("http://");
        return BaseResult.successWithData(articleTypeService.addOneEntity(articleTypeEntity));
    }
}
