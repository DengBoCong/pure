package com.dbc.service.Impl;

import com.dbc.dao.RecordRepository;
import com.dbc.entity.entity.PureRecordEntity;
import com.dbc.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordRepository recordRepository;

    @Override
    public PureRecordEntity addOneEntity(PureRecordEntity recordEntity) {
        return recordRepository.saveAndFlush(recordEntity);
    }

    @Override
    public List<PureRecordEntity> findAllByFlag(String flag) {
        return recordRepository.findAllByFlag(flag);
    }
}
