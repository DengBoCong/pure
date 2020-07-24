package com.dbc.dao;

import com.dbc.entity.entity.PureNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<PureNoticeEntity, Integer> {
    public List<PureNoticeEntity> findAllByOrderByType();
    public PureNoticeEntity findByTypeAndStatus(String type, short status);
}
