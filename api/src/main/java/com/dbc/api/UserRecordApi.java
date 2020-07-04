package com.dbc.api;

import com.dbc.entity.entity.PureUserRecordEntity;
import com.dbc.entity.entity.PureUserRecordItemEntity;
import com.dbc.entity.model.UserRecordModel;
import com.dbc.service.UserRecordService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRecord")
public class UserRecordApi {
    @Autowired
    private UserRecordService userRecordService;

    @ApiOperation(value = "根据用户的ID，查询用户的个人简历信息")
    @GetMapping("/findRecordByUserId")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "查询成功，返回相关数据"),
            @ApiResponse(code = 3, message = "数据库暂无所查数据")
    })
    public BaseResult<UserRecordModel> findUserRecordByUserId(int userId) {
        UserRecordModel userRecordModel = userRecordService.findByUserId(userId);
        if (userRecordModel == null) return BaseResult.isNull();

        return BaseResult.successWithData(userRecordModel);
    }

    @ApiOperation(value = "通过简历信息实体进行添加")
    @PostMapping("/upsertRecord")
    public BaseResult<PureUserRecordEntity> upsertRecord(PureUserRecordEntity userRecordEntity) {
        return BaseResult.successWithData(userRecordService.addOneRecord(userRecordEntity));
    }

    @ApiOperation(value = "通过简历条目进行添加更新")
    @PostMapping("/upsertItem")
    public BaseResult<PureUserRecordItemEntity> upsertItem(PureUserRecordItemEntity userRecordItemEntity) {
        return BaseResult.successWithData(userRecordService.addOneRecordItem(userRecordItemEntity));
    }
}
