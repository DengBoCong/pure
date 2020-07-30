package com.dbc.api;

import com.dbc.entity.entity.PureLanguageEntity;
import com.dbc.service.LanguageService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemApi {
    @Autowired
    private LanguageService languageService;

    @ApiOperation(value = "查询所有语言，默认type排序")
    @GetMapping("/findAllLanguage")
    @ApiResponse(code = 0, message = "查询成功")
    public BaseResult<List<PureLanguageEntity>> findAllLanguage() {
        return BaseResult.successWithData(languageService.findAllLanguageSortByType());
    }

    @ApiOperation(value = "添加或更新单个语言条目")
    @PutMapping("/addAndUpdateOne")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "添加成功，返回添加语言条目信息"),
            @ApiResponse(code = 3, message = "服务器出现错误"),
    })
    public BaseResult<List<PureLanguageEntity>> addAndUpdateOneLanguage(@RequestBody PureLanguageEntity languageEntity) {
        List<PureLanguageEntity> list = null;
        try {
            list = languageService.addAndUpdateOneEntity(languageEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(3, "服务器出现错误");
        }
        return BaseResult.successWithData(list);
    }

    @ApiOperation(value = "通过id删除语言")
    @DeleteMapping("/deleteById")
    @ApiResponse(code = 0, message = "删除成功")
    public BaseResult<List<PureLanguageEntity>> deleteById(int id) {
        try {
            languageService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器响应出错");
        }
        return BaseResult.successWithData(languageService.findAllLanguageSortByType());
    }
}
