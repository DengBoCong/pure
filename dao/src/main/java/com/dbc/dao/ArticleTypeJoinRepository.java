package com.dbc.dao;

import com.dbc.entity.entity.PureArticleTypeJoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTypeJoinRepository extends JpaRepository<PureArticleTypeJoinEntity, Integer> {
    public List<PureArticleTypeJoinEntity> findAllByTypeId(int typeId);
}
