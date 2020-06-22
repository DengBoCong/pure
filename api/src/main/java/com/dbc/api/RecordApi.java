package com.dbc.api;

import com.dbc.entity.entity.PureRecordEntity;
import com.dbc.service.RecordService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordApi {
    @Autowired
    private RecordService recordService;

    @ApiOperation(value = "根据简历类型进行查询")
    @PostMapping("/findByFlag")
    public BaseResult<List<PureRecordEntity>> findByFlag(String flag) {
        return BaseResult.successWithData(recordService.findAllByFlag(flag));
    }

    @ApiOperation(value = "单个实体插入接口")
    @PostMapping("/oneInsert")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功插入"),
            @ApiResponse(code = 1, message = "处理异常")
    })
    public BaseResult oneInsert(@RequestBody PureRecordEntity recordEntity) {
        try {
            recordService.addOneEntity(recordEntity);
        }catch (Exception e) {
            return BaseResult.failWithCodeAndMsg(1, "处理异常");
        }
        return BaseResult.success();
    }
}
