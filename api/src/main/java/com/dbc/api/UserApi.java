package com.dbc.api;

import com.dbc.entity.entity.PureAccessEntity;
import com.dbc.entity.entity.PureUserEntity;
import com.dbc.service.UserService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping("/oneInsert")
    @ApiOperation(value = "单个插入用户")
    @ApiResponse(code = 0, message = "插入成功")
    public BaseResult<PureUserEntity> oneInsert(PureUserEntity userEntity) {
        return BaseResult.successWithData(userService.addOneEntity(userEntity));
    }

    @GetMapping("/findByAccess")
    public BaseResult<List<PureUserEntity>> findByAccess(String access) {
        List<PureUserEntity> list = null;
        try {
            list = userService.findByAccess(access);
        }catch (Exception e) {
            return BaseResult.failWithCodeAndMsg(1, "服务器出现异常");
        }
        if (list == null) return BaseResult.isNull();
        else return BaseResult.successWithData(list);
    }
}
