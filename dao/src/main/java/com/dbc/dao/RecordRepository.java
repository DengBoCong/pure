package com.dbc.dao;

import com.dbc.entity.entity.PureRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<PureRecordEntity, Integer> {
    public List<PureRecordEntity> findAllByFlag(String flag);
}
