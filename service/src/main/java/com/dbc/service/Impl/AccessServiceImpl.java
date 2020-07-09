package com.dbc.service.Impl;

import com.dbc.dao.AccessPathRepository;
import com.dbc.dao.AccessRepository;
import com.dbc.entity.entity.PureAccessPathEntity;
import com.dbc.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accessService")
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessPathRepository accessPathRepository;

    @Override
    public List<PureAccessPathEntity> findPathByAccess(String access) {
        return accessPathRepository.findAllByAccessLessThanEqual(access);
    }

    @Override
    public PureAccessPathEntity findAccessByPath(String path) {
        return accessPathRepository.findByAccessPath(path);
    }
}
