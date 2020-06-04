package com.dbc.dao;

import com.dbc.entity.entity.PureArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<PureArticleEntity, Integer> {
}
