package com.dbc.service;

import com.dbc.entity.entity.PureRecordEntity;

import java.util.List;

public interface RecordService {
    public PureRecordEntity addOneEntity(PureRecordEntity recordEntity);
    public List<PureRecordEntity> findAllByFlag(String flag);
}
