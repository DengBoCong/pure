package com.dbc.service.Impl;

import com.dbc.dao.UserRecordItemRepository;
import com.dbc.dao.UserRecordRepository;
import com.dbc.entity.entity.PureUserRecordEntity;
import com.dbc.entity.entity.PureUserRecordItemEntity;
import com.dbc.entity.model.UserRecordModel;
import com.dbc.service.UserRecordService;
import com.dbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRecordService")
public class UserRecordServiceImpl implements UserRecordService {
    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private UserRecordItemRepository userRecordItemRepository;

    @Override
    public UserRecordModel findByUserId(int userId) {
        PureUserRecordEntity userRecordEntity = userRecordRepository.findByUserId(userId);
        if (userRecordEntity == null) return null;

        UserRecordModel userRecordModel = new UserRecordModel();
        userRecordModel.setUserRecordEntity(userRecordEntity);
        userRecordModel.setItemEntities(userRecordItemRepository.findAllByRecordId(userRecordEntity.getId()));

        return userRecordModel;
    }

    @Override
    public PureUserRecordEntity addOneRecord(PureUserRecordEntity userRecordEntity) {
        return userRecordRepository.saveAndFlush(userRecordEntity);
    }

    @Override
    public PureUserRecordItemEntity addOneRecordItem(PureUserRecordItemEntity userRecordItemEntity) {
        return userRecordItemRepository.saveAndFlush(userRecordItemEntity);
    }
}
