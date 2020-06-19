package com.dbc.dao;

import com.dbc.entity.entity.PurePhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PurePhotoEntity, Integer> {
}
