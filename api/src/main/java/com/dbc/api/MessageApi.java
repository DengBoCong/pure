package com.dbc.api;

import com.dbc.entity.entity.PureAdvertiseEntity;
import com.dbc.entity.entity.PureNoticeEntity;
import com.dbc.service.AdvertiseService;
import com.dbc.service.NoticeService;
import com.dbc.utils.BaseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageApi {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private AdvertiseService advertiseService;

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

    @ApiOperation(value = "查询所有的通告，默认他通过类型标记排序")
    @GetMapping("/findAllNotice")
    @ApiResponse(code = 0, message = "查询成功返回查询数据")
    public BaseResult<List<PureNoticeEntity>> findAllNoticeSortByType() {
        return BaseResult.successWithData(noticeService.findAllByOrderByType());
    }

    @ApiOperation(value = "添加或更新单个通告接口")
    @PutMapping("/addAndUpdateOneNotice")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "添加成功，返回添加通告信息"),
            @ApiResponse(code = 3, message = "服务器出现错误"),
    })
    public BaseResult<List<PureNoticeEntity>> addAndUpdateOneNotice(@RequestBody PureNoticeEntity noticeEntity) {
        PureNoticeEntity pureNoticeEntity = null;
        try {
            pureNoticeEntity = noticeService.addAndUpdateOne(noticeEntity);
        } catch (Exception e) { 
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(3, "服务器出现错误");
        }
        return BaseResult.successWithData(noticeService.findAllByOrderByType());
    }

    @ApiOperation(value = "通过id删除单个通告")
    @DeleteMapping("/deleteOneNoticeById")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "删除成功"),
            @ApiResponse(code = 1, message = "服务器响应出错"),
    })
    public BaseResult<List<PureNoticeEntity>> deleteNoticeById(int id) {
        try {
            noticeService.deleteOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器响应出错");
        }
        return BaseResult.successWithData(noticeService.findAllByOrderByType());
    }

    @ApiOperation(value = "通过广告的类型组进行查询，默认查询状态为1，即激活状态")
    @GetMapping("/findAdvertiseByType")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "查询成功返回查询数据"),
            @ApiResponse(code = 1, message = "服务器响应出错"),
            @ApiResponse(code = 3, message = "查询数据为空")
    })
    public BaseResult<List<PureAdvertiseEntity>> findAdvertiseByType(String type) {
        List<PureAdvertiseEntity> list = null;
        try {
            list = advertiseService.findAllByTypeAndStatus(type, (short)1);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器响应出错");
        }
        if (list.isEmpty()) return BaseResult.isNull();
        return BaseResult.successWithData(list);
    }

    @ApiOperation(value = "查询所有广告信息，默认type排序")
    @GetMapping("/findAllAdvertise")
    @ApiResponse(code = 0, message = "查询成功")
    public BaseResult<List<PureAdvertiseEntity>> findAllAdvertiseSortByType() {
        return BaseResult.successWithData(advertiseService.findAllByOrderByType());
    }

    @ApiOperation(value = "添加或更新单个广告接口")
    @PutMapping("/addAndUpdateOneAdvertise")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "添加成功，返回添加广告信息"),
            @ApiResponse(code = 3, message = "服务器出现错误"),
    })
    public BaseResult<List<PureAdvertiseEntity>> addAndUpdateOneAdvertise(@RequestBody PureAdvertiseEntity advertiseEntity) {
        PureAdvertiseEntity pureAdvertiseEntity = null;
        try {
            pureAdvertiseEntity = advertiseService.addAndUpdateOne(advertiseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(3, "服务器出现错误");
        }
        return BaseResult.successWithData(advertiseService.findAllByOrderByType());
    }

    @ApiOperation(value = "通过id删除单个广告")
    @DeleteMapping("/deleteOneAdvertiseById")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "删除成功"),
            @ApiResponse(code = 1, message = "服务器响应出错"),
    })
    public BaseResult<List<PureAdvertiseEntity>> deleteAdvertiseById(int id) {
        try {
            advertiseService.deleteOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.failWithCodeAndMsg(1, "服务器响应出错");
        }
        return BaseResult.successWithData(advertiseService.findAllByOrderByType());
    }
}
