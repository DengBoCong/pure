package com.dbc.service.Impl;

import com.dbc.dao.UserRepository;
import com.dbc.entity.entity.PureUserEntity;
import com.dbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PureUserEntity> findByAccess(String access) {
        return userRepository.findAllByAccess(access);
    }

    @Override
    public PureUserEntity addOneEntity(PureUserEntity userEntity) {
        return userRepository.saveAndFlush(userEntity);
    }
}
