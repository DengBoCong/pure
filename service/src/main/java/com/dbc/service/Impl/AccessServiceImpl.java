package com.dbc.service.Impl;

import com.dbc.dao.AccessPathRepository;
import com.dbc.dao.AccessRepository;
import com.dbc.entity.entity.PureAccessPathEntity;
import com.dbc.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accessService")
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessPathRepository accessPathRepository;

    @Override
    public List<PureAccessPathEntity> findAllOrderBySort() {
        return accessPathRepository.findAllByOrderBySort();
    }

    @Override
    public List<PureAccessPathEntity> findPathByAccess(String access) {
        return accessPathRepository.findAllByAccessLessThanEqual(access);
    }

    @Override
    public PureAccessPathEntity findAccessByPath(String path) {
        return accessPathRepository.findByAccessPath(path);
    }

    @Override
    public PureAccessPathEntity addOneEntity(PureAccessPathEntity accessPathEntity) {
        if (accessPathEntity.getId() == 0) {
            return accessPathRepository.save(accessPathEntity);
        } else {
            PureAccessPathEntity accessPathEntity1 = null;
            accessPathEntity1 = accessPathRepository.findById(accessPathEntity.getId());
            if (accessPathEntity.getStatus() != accessPathEntity1.getStatus()) {
                accessPathEntity1.setStatus(accessPathEntity.getStatus());
            }
            if (accessPathEntity.getAccess() != null) {
                accessPathEntity1.setAccess(accessPathEntity.getAccess());
            }
            if (accessPathEntity.getDescription() != null) {
                accessPathEntity1.setDescription(accessPathEntity.getDescription());
            }
            return accessPathRepository.save(accessPathEntity1);
        }
    }
}
