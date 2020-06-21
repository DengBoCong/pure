package com.dbc.api;

import com.dbc.entity.entity.PureAdvertiseEntity;
import com.dbc.service.AdvertiseService;
import com.dbc.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advertise")
public class AdvertiseApi {
    @Autowired
    private AdvertiseService advertiseService;

    public BaseResult<List<PureAdvertiseEntity>> findByType(String type) {
        return BaseResult.successWithData(advertiseService.findAllByType(type));
    }
}
