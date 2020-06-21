package com.dbc.service;

import com.dbc.entity.entity.PureNoticeEntity;

import java.util.List;

public interface NoticeService {
    public PureNoticeEntity findByType(String type);
}
