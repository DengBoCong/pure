package com.dbc.service;

import com.dbc.entity.entity.PureAccessPathEntity;

import java.util.List;

public interface AccessService {
    public List<PureAccessPathEntity> findAllOrderBySort();
    public List<PureAccessPathEntity> findPathByAccess(String access);
    public PureAccessPathEntity findAccessByPath(String path);
    public PureAccessPathEntity addOneEntity(PureAccessPathEntity accessPathEntity);
    public List<PureAccessPathEntity> addManyEntity(List<PureAccessPathEntity> list);
    public PureAccessPathEntity deleteOneEntity(int id);
}
