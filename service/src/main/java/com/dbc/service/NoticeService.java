package com.dbc.service;

import com.dbc.entity.entity.PureNoticeEntity;

import java.util.List;

public interface NoticeService {
    public List<PureNoticeEntity> findAllByOrderByType();
    public PureNoticeEntity findByTypeAndStatus(String type, short status);
}
