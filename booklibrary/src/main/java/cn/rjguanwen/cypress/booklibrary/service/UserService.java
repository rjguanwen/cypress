package cn.rjguanwen.cypress.booklibrary.service;

import cn.rjguanwen.cypress.booklibrary.entity.User;
import cn.rjguanwen.cypress.booklibrary.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: 郑斌
 * @Date: 2019/3/22 9:31
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User sel(int userId){
        return userMapper.sel(userId);
    }

    public List<User> getAll(){
        return userMapper.getAll();
    }

}
