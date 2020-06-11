package com.dbc.dao;

import com.dbc.entity.entity.PureUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PureUserEntity, Integer> {
}
