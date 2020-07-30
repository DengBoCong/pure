package com.dbc.service.Impl;

import com.dbc.dao.LanguageRepository;
import com.dbc.entity.entity.PureLanguageEntity;
import com.dbc.service.LanguageService;
import com.dbc.service.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<PureLanguageEntity> findAllLanguageSortByType() {
        return languageRepository.findAllByOrderByType();
    }

    @Override
    public List<PureLanguageEntity> addAndUpdateOneEntity(PureLanguageEntity languageEntity) {
        if (languageEntity.getId() == 0) {
            languageEntity.setAddTime(DateUtils.NewDateInt());
            languageRepository.save(languageEntity);
        } else {
            PureLanguageEntity pureLanguageEntity = languageRepository.findById(languageEntity.getId());
            if (languageEntity.getType() != "")
                pureLanguageEntity.setType(languageEntity.getType());
            if (languageEntity.getTitle() != "")
                pureLanguageEntity.setTitle(languageEntity.getTitle());
            if (languageEntity.getZhCn() != "")
                pureLanguageEntity.setZhCn(languageEntity.getZhCn());
            if (languageEntity.getEnUs() != "")
                pureLanguageEntity.setEnUs(languageEntity.getEnUs());
            if (languageEntity.getZhTw() != "")
                pureLanguageEntity.setZhTw(languageEntity.getZhTw());

            languageRepository.save(pureLanguageEntity);
        }
        return languageRepository.findAllByOrderByType();
    }

    @Override
    public List<PureLanguageEntity> deleteById(int id) {
        return languageRepository.deleteById(id);
    }
}
