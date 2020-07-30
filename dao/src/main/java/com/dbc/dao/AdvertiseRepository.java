package com.dbc.dao;

import com.dbc.entity.entity.PureAdvertiseEntity;
import com.dbc.entity.entity.PureNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertiseRepository extends JpaRepository<PureAdvertiseEntity, Integer> {
    public List<PureAdvertiseEntity> findAllByTypeAndStatus(String type, short status);
    public List<PureAdvertiseEntity> findAllByOrderByType();
    public PureAdvertiseEntity findById(int id);
    public PureAdvertiseEntity deleteById(int id);
}
