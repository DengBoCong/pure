package com.dbc.service;

import com.dbc.entity.entity.PureUserEntity;

import java.util.List;

public interface UserService {
    public PureUserEntity findByAccount(String account);
    public List<PureUserEntity> findByAccess(String access);
    public PureUserEntity addOneEntity(PureUserEntity userEntity);
}
