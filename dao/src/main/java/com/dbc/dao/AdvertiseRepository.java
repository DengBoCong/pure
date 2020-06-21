package com.dbc.dao;

import com.dbc.entity.entity.PureAdvertiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertiseRepository extends JpaRepository<PureAdvertiseEntity, Integer> {
    public List<PureAdvertiseEntity> findAllByType(String type);
}
