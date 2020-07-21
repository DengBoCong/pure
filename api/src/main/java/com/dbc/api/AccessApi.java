package com.dbc.api;

import com.dbc.entity.entity.PureAccessPathEntity;
import com.dbc.service.AccessService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "直接查询所有访问权限路径，默认sort排序")
    @GetMapping("/findAllOrderBySort")
    @ApiResponse(code = 0, message = "查询成功")
    public BaseResult<List<PureAccessPathEntity>> findAllOrderBySort() {
        return BaseResult.successWithData(accessService.findAllOrderBySort());
    }

    @ApiOperation(value = "对单个实体进行插入和更新")
    @PutMapping("/oneInsertUpdate")
    @ApiResponse(code = 0, message = "添加或更新成功")
    public BaseResult<PureAccessPathEntity> insertAndUpdate(@RequestBody PureAccessPathEntity accessPathEntity) {
        return BaseResult.successWithData(accessService.addOneEntity(accessPathEntity));
    }

    @ApiOperation(value = "批量添加用户访问地址，默认权限为SUPER")
    @PutMapping("/manyInsert")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "批量添加成功"),
            @ApiResponse(code = 1, message = "服务器响应出错"),
            @ApiResponse(code = 3, message = "数据量为空")
    })
    public BaseResult<List<PureAccessPathEntity>> manyInsert(@RequestBody List<PureAccessPathEntity> list) {
        List<PureAccessPathEntity> list1 = null;
        try {
            list1 = accessService.addManyEntity(list);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器响应出错");
        }
        if (list1 == null) return BaseResult.isNull();
        return BaseResult.successWithData(list1);
    }
}
