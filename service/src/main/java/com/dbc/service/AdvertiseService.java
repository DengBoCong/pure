package com.dbc.service;

import com.dbc.entity.entity.PureAdvertiseEntity;

import java.util.List;

public interface AdvertiseService {
    public PureAdvertiseEntity findAllByType(String type);
}
