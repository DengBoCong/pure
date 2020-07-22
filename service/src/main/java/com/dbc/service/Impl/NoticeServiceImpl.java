package com.dbc.service.Impl;

import com.dbc.dao.NoticeRepository;
import com.dbc.entity.entity.PureNoticeEntity;
import com.dbc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public PureNoticeEntity findByTypeAndStatus(String type, short status) {
        return noticeRepository.findByTypeAndStatus(type, status);
    }
}
