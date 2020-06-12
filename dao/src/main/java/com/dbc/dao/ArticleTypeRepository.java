package com.dbc.dao;

import com.dbc.entity.entity.PureArticleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTypeRepository extends JpaRepository<PureArticleTypeEntity, Integer> {
}
