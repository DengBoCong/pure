package com.dbc.dao;

import com.dbc.entity.entity.PureArticleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTypeRepository extends JpaRepository<PureArticleTypeEntity, Integer> {
}
