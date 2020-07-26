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

    @Override
    public List<PureNoticeEntity> findAllByOrderByType() {
        return noticeRepository.findAllByOrderByType();
    }

    @Override
    public PureNoticeEntity addAndUpdateOne(PureNoticeEntity noticeEntity) {
        if (noticeEntity.getId() == 0) {
            return noticeRepository.save(noticeEntity);
        } else {
            PureNoticeEntity pureNoticeEntity = noticeRepository.findById(noticeEntity.getId());
            if (!noticeEntity.getContent().equals(""))
                pureNoticeEntity.setContent(noticeEntity.getContent());
            if (!noticeEntity.getContentColor().equals(""))
                pureNoticeEntity.setContentColor(noticeEntity.getContentColor());
            if (!noticeEntity.getTitle().equals(""))
                pureNoticeEntity.setTitle(noticeEntity.getTitle());
            if (!noticeEntity.getTitleColor().equals(""))
                pureNoticeEntity.setTitleColor(noticeEntity.getTitleColor());
            if (!noticeEntity.getDescription().equals(""))
                pureNoticeEntity.setDescription(noticeEntity.getDescription());
            if (noticeEntity.getReserveTime() != 0)
                pureNoticeEntity.setReserveTime(noticeEntity.getReserveTime());
            if (noticeEntity.getSort() != -1)
                pureNoticeEntity.setSort(noticeEntity.getSort());
            if (!noticeEntity.getType().equals(""))
                pureNoticeEntity.setType(noticeEntity.getType());
            if (noticeEntity.getStatus() != -1)
                pureNoticeEntity.setStatus(noticeEntity.getStatus());
            if (!noticeEntity.getUrl().equals(""))
                pureNoticeEntity.setUrl(noticeEntity.getUrl());
            return noticeRepository.save(pureNoticeEntity);
        }
    }

    @Override
    public PureNoticeEntity deleteOneById(int id) {
        return noticeRepository.deleteById(id);
    }
}
