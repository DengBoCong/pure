package com.dbc.api;

import com.dbc.entity.entity.PureNoticeEntity;
import com.dbc.service.NoticeService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {
    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "根据Notice的type查询信息")
    @GetMapping("/findNoticeByType")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "查询成功返回查询数据"),
            @ApiResponse(code = 1, message = "服务器响应出错"),
            @ApiResponse(code = 3, message = "查询数据为空")
    })
    public BaseResult<PureNoticeEntity> findNoticeByType(String type) {
        PureNoticeEntity noticeEntity = null;
        try {
            noticeEntity = noticeService.findByTypeAndStatus(type, (short) 1);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器响应出错");
        }
        if (noticeEntity == null) return BaseResult.isNull();
        return BaseResult.successWithData(noticeEntity);
    }
}
