package com.dbc.dao;

import com.dbc.entity.entity.PureAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<PureAccessEntity, Integer> {
}
