package com.dbc.service;

import com.dbc.entity.entity.PureAdvertiseEntity;

import java.util.List;

public interface AdvertiseService {
    public List<PureAdvertiseEntity> findAllByTypeAndStatus(String type, short status);
    public List<PureAdvertiseEntity> findAllByOrderByType();
}
