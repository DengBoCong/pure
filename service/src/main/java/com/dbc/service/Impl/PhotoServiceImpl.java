package com.dbc.service.Impl;

import com.dbc.dao.PhotoRepository;
import com.dbc.entity.entity.PurePhotoEntity;
import com.dbc.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    @Override
    public PurePhotoEntity oneInsert(PurePhotoEntity photoEntity) {
        return photoRepository.save(photoEntity);
    }
}
