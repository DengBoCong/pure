package com.dbc.entity.model;

import com.dbc.entity.entity.PureUserRecordEntity;
import com.dbc.entity.entity.PureUserRecordItemEntity;

import java.io.Serializable;
import java.util.List;

public class UserRecordModel implements Serializable {
    public PureUserRecordEntity userRecordEntity;
    public List<PureUserRecordItemEntity> itemEntities;

    public PureUserRecordEntity getUserRecordEntity() {
        return userRecordEntity;
    }

    public void setUserRecordEntity(PureUserRecordEntity userRecordEntity) {
        this.userRecordEntity = userRecordEntity;
    }

    public List<PureUserRecordItemEntity> getItemEntities() {
        return itemEntities;
    }

    public void setItemEntities(List<PureUserRecordItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
    }

    @Override
    public String toString() {
        return "UserRecordModel{" +
                "userRecordEntity=" + userRecordEntity +
                ", itemEntities=" + itemEntities +
                '}';
    }
}
