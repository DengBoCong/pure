package com.dbc.service.Impl;

import com.dbc.dao.AdvertiseRepository;
import com.dbc.entity.entity.PureAdvertiseEntity;
import com.dbc.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("advertiseService")
public class AdvertiseServiceImpl implements AdvertiseService {
    @Autowired
    private AdvertiseRepository advertiseRepository;

    @Override
    public List<PureAdvertiseEntity> findAllByTypeAndStatus(String type, short status) {
        return advertiseRepository.findAllByTypeAndStatus(type, status);
    }
}
