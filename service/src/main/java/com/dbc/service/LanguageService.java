package com.dbc.service;

import com.dbc.entity.entity.PureLanguageEntity;

import java.util.List;


public interface LanguageService {
    public List<PureLanguageEntity> findAllLanguageSortByType();
    public List<PureLanguageEntity> addAndUpdateOneEntity(PureLanguageEntity languageEntity);
    public List<PureLanguageEntity> deleteById(int id);
}
