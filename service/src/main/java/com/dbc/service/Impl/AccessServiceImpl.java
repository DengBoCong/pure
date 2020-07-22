package com.dbc.service.Impl;

import com.dbc.dao.AccessPathRepository;
import com.dbc.dao.AccessRepository;
import com.dbc.entity.entity.PureAccessPathEntity;
import com.dbc.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<PureAccessPathEntity> addManyEntity(List<PureAccessPathEntity> list) {
        Map map = new HashMap();
        List<PureAccessPathEntity> dataBase = accessPathRepository.findAllByOrderBySort();
        for (PureAccessPathEntity accessPathEntity : dataBase) {
            map.put(accessPathEntity.getAccessPath(), accessPathEntity.getDescription());
        }

        PureAccessPathEntity pathEntity = null;
        List<PureAccessPathEntity> result = new ArrayList<>();
        for (PureAccessPathEntity accessPathEntity : list) {
            if (!map.containsKey(accessPathEntity.getAccessPath())) {
                pathEntity = new PureAccessPathEntity();
                pathEntity.setAccessPath(accessPathEntity.getAccessPath());
                pathEntity.setDescription(accessPathEntity.getDescription());
                result.add(pathEntity);
            }
        }

        return accessPathRepository.saveAll(result);
    }

    @Override
    public PureAccessPathEntity deleteOneEntity(int id) {
        return accessPathRepository.deleteById(id);
    }
}
