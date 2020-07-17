package com.dbc.api;

import com.alibaba.fastjson.JSONObject;
import com.dbc.entity.entity.PureAccessEntity;
import com.dbc.entity.entity.PureAccessPathEntity;
import com.dbc.entity.entity.PureUserEntity;
import com.dbc.entity.model.UserRecordModel;
import com.dbc.service.AccessService;
import com.dbc.service.UserRecordService;
import com.dbc.service.UserService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @Autowired
    private AccessService accessService;

    @ApiOperation(value = "通过账户、密码、平台等相关信息进行登录")
    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "查询成功"),
            @ApiResponse(code = 1, message = "数据查询出现异常"),
            @ApiResponse(code = 3, message = "数据为空")
    })
    public BaseResult<PureUserEntity> login(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        PureUserEntity userEntity = null;
        try {
            userEntity = userService.findByAccount(jsonObject.get("account").toString());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "数据查询出现异常");
        }
        if (userEntity == null) return BaseResult.isNull();
        return BaseResult.successWithData(userEntity);
    }

    @PostMapping("/oneInsert")
    @ApiOperation(value = "单个插入用户")
    @ApiResponse(code = 0, message = "插入成功")
    public BaseResult<PureUserEntity> oneInsert(PureUserEntity userEntity) {
        return BaseResult.successWithData(userService.addOneEntity(userEntity));
    }

    @PostMapping("/checkAccess")
    public BaseResult checkAccess(String access, String path) {
        PureAccessPathEntity accessPathEntity = null;
        try {
            accessPathEntity = accessService.findAccessByPath(path);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器出现异常");
        }
        if (accessPathEntity == null) return BaseResult.failWithCodeAndMsg(2, "账号未授权");

        if (accessPathEntity.getAccess().compareTo(access) > 0)
            return BaseResult.failWithCodeAndMsg(2, "账号未授权");
        else return BaseResult.success();
    }

    @ApiOperation(value = "直接查询最高等级用户信息")
    @GetMapping("/findSuper")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "查询成功"),
            @ApiResponse(code = 1, message = "服务器出现异常"),
            @ApiResponse(code = 3, message = "超级管理员数据为空")
    })
    public BaseResult<PureUserEntity> findSuperUser() {
        List<PureUserEntity> list = null;
        try {
            list = userService.findByAccess("SUPER");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器出现异常");
        }
        if (list.size() == 0) return BaseResult.isNull();
        return BaseResult.successWithData(list.get(0));
    }
}
