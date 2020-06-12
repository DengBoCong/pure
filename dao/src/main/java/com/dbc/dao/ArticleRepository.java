package com.dbc.dao;

import com.dbc.entity.entity.PureArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<PureArticleEntity, Integer> {
}
