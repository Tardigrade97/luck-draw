package com.example.lduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lduser.po.User;
import com.example.lduser.service.UserService;
import com.example.lduser.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author DuanXuYang
* @description 针对表【ld_user】的数据库操作Service实现
* @createDate 2023-03-09 17:19:14
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




