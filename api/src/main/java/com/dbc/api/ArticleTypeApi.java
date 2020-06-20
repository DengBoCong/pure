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

    @ApiOperation(value = "根据文章分类ID进行查询")
    @PostMapping("/findTypeById")
    @ApiResponse(code = 0, message = "查询成功，没有对应的值的话就为空")
    public BaseResult<PureArticleTypeEntity> findArticleTypeById(int id) {
        return BaseResult.successWithData(articleTypeService.findById(id));
    }

    @ApiOperation(value = "文章分类专栏添加以及更新接口")
    @PostMapping("/oneInsertAndUpdate")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败"),
            @ApiResponse(code = 3, message = "接收到的数据为空")
    })
    public BaseResult oneInsertAndUpdate(@RequestBody PureArticleTypeEntity articleTypeEntity) {
        if (articleTypeEntity == null) return BaseResult.failWithCodeAndMsg(3, "请求传输数据为空");
        PureArticleTypeEntity tmp = null;
        if (articleTypeEntity.getId() != 0) {
            tmp = articleTypeService.findById(articleTypeEntity.getId());
            tmp.setStatus(articleTypeEntity.getStatus());
            if (articleTypeEntity.getDescription() != null)
                tmp.setDescription(articleTypeEntity.getDescription());
            if (articleTypeEntity.getName() != null)
                tmp.setName(articleTypeEntity.getName());
            if (articleTypeEntity.getFontCover() != null) {
                tmp.setFontCover(articleTypeEntity.getFontCover());
            }
            articleTypeService.addOneEntity(tmp);
        }

        tmp = articleTypeEntity;
        tmp.setAddTime(DateUtils.NewDateInt());
        tmp.setFontCover(articleTypeEntity.getFontCover());
        try {
            articleTypeService.addOneEntity(tmp);
        }catch (Exception e) {
            return BaseResult.failWithCodeAndMsg(1, "请求处理出现异常");
        }
        return BaseResult.successWithData(articleTypeService.findAll());
    }

    @ApiOperation(value = "根据转过来的ID删除文章分类专栏")
    @PostMapping("/oneDelete")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "删除成功"),
            @ApiResponse(code = 1, message = "删除出现异常")
    })
    public BaseResult oneDelete(int id) {
        try {
            articleTypeService.deleteOneEntityById(id);
        }catch (Exception e) {
            BaseResult.failWithCodeAndMsg(1, "删除出现异常");
        }
        return BaseResult.successWithData(articleTypeService.findAll());
    }
}
