package com.github.shardingjdbcdemo.web;

import com.github.shardingjdbcdemo.entity.User;
import com.github.shardingjdbcdemo.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 许大仙
 * @version 1.0
 * @since 2022-12-02 17:33:12
 */
@RestController
@RequestMapping(value = "/user")
public class UserAction {


    private final UserMapper userMapper;

    public UserAction(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/list")
    public List<User> list(){
        return userMapper.selectList(null);
    }

}
