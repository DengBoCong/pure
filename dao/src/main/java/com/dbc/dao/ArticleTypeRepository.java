package com.dbc.dao;

import com.dbc.entity.entity.PureArticleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTypeRepository extends JpaRepository<PureArticleTypeEntity, Integer> {
    public List<PureArticleTypeEntity> findAllByStatus(boolean status);
}
