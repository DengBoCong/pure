package com.dbc.service;

import com.dbc.entity.entity.PureUserRecordEntity;
import com.dbc.entity.entity.PureUserRecordItemEntity;
import com.dbc.entity.model.UserRecordModel;

public interface UserRecordService {
    public UserRecordModel findByUserId(int userId);
    public PureUserRecordEntity addOneRecord(PureUserRecordEntity userRecordEntity);
    public PureUserRecordItemEntity addOneRecordItem(PureUserRecordItemEntity userRecordItemEntity);
}
