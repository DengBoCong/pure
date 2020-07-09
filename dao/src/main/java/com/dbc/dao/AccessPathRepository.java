package com.dbc.dao;

import com.dbc.entity.entity.PureAccessPathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessPathRepository extends JpaRepository<PureAccessPathEntity, Integer> {
    public List<PureAccessPathEntity> findAllByAccessLessThanEqual(String access);
    public PureAccessPathEntity findByAccessPath(String path);
}
