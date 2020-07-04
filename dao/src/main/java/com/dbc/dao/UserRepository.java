package com.dbc.dao;

import com.dbc.entity.entity.PureUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<PureUserEntity, Integer> {
    public List<PureUserEntity> findAllByAccess(String access);
}
