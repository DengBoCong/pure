package com.dbc.dao;

import com.dbc.entity.entity.PureUserRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecordRepository extends JpaRepository<PureUserRecordEntity, Integer> {
    public PureUserRecordEntity findByUserId(int userId);
}
