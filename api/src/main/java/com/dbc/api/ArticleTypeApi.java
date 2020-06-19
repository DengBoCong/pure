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
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "查询成功"),
            @ApiResponse(code = 1, message = "查询失败, 因服务端出现异常")
    })
    public BaseResult<List<PureArticleTypeEntity>> findArticleType() {
        List<PureArticleTypeEntity> dataList = null;
        try {
            dataList = articleTypeService.findAll();
        }catch (Exception e) {
            return BaseResult.failWithCodeAndMsg(1, "查询失败");
        }
        return BaseResult.successWithData(dataList);
    }

    @ApiOperation(value = "文章分类专栏添加接口")
    @PostMapping("/oneInsert")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败"),
    })
    public BaseResult oneInsert(@RequestBody PureArticleTypeEntity articleTypeEntity) {
        articleTypeEntity.setAddTime(DateUtils.NewDateInt());
        articleTypeEntity.setFontCover("http://");
        try {
            articleTypeService.addOneEntity(articleTypeEntity);
        }catch (Exception e) {
            return BaseResult.failWithCodeAndMsg(1, "请求处理出现异常");
        }
        return BaseResult.successWithData(articleTypeService.findAll());
    }

    @ApiOperation(value = "根据转过来的ID删除文章分类专栏")
    @PostMapping("/oneDelete")
    public BaseResult oneDelete(int id) {
        try {
            articleTypeService.deleteOneEntityById(id);
        }catch (Exception e) {
            BaseResult.failWithCodeAndMsg(1, "删除出现异常");
        }
        return BaseResult.successWithData(articleTypeService.findAll());
    }
}
