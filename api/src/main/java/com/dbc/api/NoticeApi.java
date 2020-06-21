package com.dbc.api;

import com.dbc.entity.entity.PureNoticeEntity;
import com.dbc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeApi {
    @Autowired
    private NoticeService noticeService;

    public PureNoticeEntity findByType(String type) {
        return noticeService.findByType(type);
    }
}
