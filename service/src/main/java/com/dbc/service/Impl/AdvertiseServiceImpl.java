package com.dbc.service.Impl;

import com.dbc.dao.AdvertiseRepository;
import com.dbc.entity.entity.PureAdvertiseEntity;
import com.dbc.entity.entity.PureNoticeEntity;
import com.dbc.service.AdvertiseService;
import com.dbc.service.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("advertiseService")
public class AdvertiseServiceImpl implements AdvertiseService {
    @Autowired
    private AdvertiseRepository advertiseRepository;

    @Override
    public List<PureAdvertiseEntity> findAllByTypeAndStatus(String type, short status) {
        return advertiseRepository.findAllByTypeAndStatus(type, status);
    }

    @Override
    public List<PureAdvertiseEntity> findAllByOrderByType() {
        return advertiseRepository.findAllByOrderByType();
    }

    @Override
    public PureAdvertiseEntity addAndUpdateOne(PureAdvertiseEntity advertiseEntity) {
        if (advertiseEntity.getId() == 0) {
            advertiseEntity.setAddTime(DateUtils.NewDateInt());
            return advertiseRepository.save(advertiseEntity);
        } else {
            PureAdvertiseEntity pureAdvertiseEntity = advertiseRepository.findById(advertiseEntity.getId());
            if (!advertiseEntity.getTitle().equals(""))
                pureAdvertiseEntity.setTitle(advertiseEntity.getTitle());
            if (!advertiseEntity.getType().equals(""))
                pureAdvertiseEntity.setType(advertiseEntity.getType());
            if (advertiseEntity.getSort() != -1)
                pureAdvertiseEntity.setSort(advertiseEntity.getSort());
            if (advertiseEntity.getReserveTime() != 0)
                pureAdvertiseEntity.setReserveTime(advertiseEntity.getReserveTime());
            if (!advertiseEntity.getCover().equals(""))
                pureAdvertiseEntity.setCover(advertiseEntity.getCover());
            if (!advertiseEntity.getDescription().equals(""))
                pureAdvertiseEntity.setDescription(advertiseEntity.getDescription());
            if (advertiseEntity.getStatus() != -1)
                pureAdvertiseEntity.setStatus(advertiseEntity.getStatus());

            return advertiseRepository.save(pureAdvertiseEntity);
        }
    }

    @Override
    public PureAdvertiseEntity deleteOneById(int id) {
        return advertiseRepository.deleteById(id);
    }
}
