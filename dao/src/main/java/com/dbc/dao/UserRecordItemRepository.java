package com.dbc.dao;

import com.dbc.entity.entity.PureUserRecordItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRecordItemRepository extends JpaRepository<PureUserRecordItemEntity, Integer> {
    public List<PureUserRecordItemEntity> findAllByRecordId(int recordId);
}
