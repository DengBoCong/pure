package com.dbc.dao;

import com.dbc.entity.entity.PureArticleTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTagRepository extends JpaRepository<PureArticleTagEntity, Integer> {
}
