package com.dbc.dao;

import com.dbc.entity.entity.PureArticleTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTagRepository extends JpaRepository<PureArticleTagEntity, Integer> {
    public List<PureArticleTagEntity> findAllByArticleId(int articleId);
}
