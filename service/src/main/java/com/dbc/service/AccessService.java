package com.dbc.service;

import com.dbc.entity.entity.PureAccessPathEntity;

import java.util.List;

public interface AccessService {
    public List<PureAccessPathEntity> findPathByAccess(String access);
}
