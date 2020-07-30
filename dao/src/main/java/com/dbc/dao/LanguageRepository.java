package com.dbc.dao;

import com.dbc.entity.entity.PureLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<PureLanguageEntity, Integer> {
    public List<PureLanguageEntity> findAllByOrderByType();
    public PureLanguageEntity findById(int id);
    public List<PureLanguageEntity> deleteById(int id);
}
