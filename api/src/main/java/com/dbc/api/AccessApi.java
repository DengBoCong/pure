package com.dbc.api;

import com.dbc.entity.entity.PureAccessPathEntity;
import com.dbc.service.AccessService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/access")
public class AccessApi {
    @Autowired
    private AccessService accessService;

    @ApiOperation(value = "通过权限名称，查询该权限下所有的访问路径")
    @GetMapping("/findPathByAccess")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "查询成功"),
            @ApiResponse(code = 1, message = "数据查询出现异常")
    })
    public BaseResult<List<PureAccessPathEntity>> findPathByAccess(String access) {
        List<PureAccessPathEntity> list = null;
        try {
            list = accessService.findPathByAccess(access);
        } catch (Exception e) {
            return BaseResult.failWithCodeAndMsg(1, "服务器出现异常");
        }
        if (list == null) return BaseResult.isNull();
        else return BaseResult.successWithData(list);
    }
}
