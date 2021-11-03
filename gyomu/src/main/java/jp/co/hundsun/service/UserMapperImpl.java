package jp.co.hundsun.service;

import jp.co.hundsun.entity.User;
import jp.co.hundsun.mapper.UserMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl  implements UserMapper {

    @Autowired
    UserMapper userMapper;

    @Override
    public User fetchById(Integer id) {
        return userMapper.fetchById(id);
    }


}
