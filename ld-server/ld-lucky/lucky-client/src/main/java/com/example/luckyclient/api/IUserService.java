package com.example.luckyclient.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.luckyclient.dto.UserRegisterCmd;
import com.example.luckyclient.dto.data.UserVO;
import com.example.luckyclient.dto.query.UserListByParamQuery;
import com.example.luckyclient.dto.query.UserLoginQuery;
import com.example.luckyclient.dto.query.UserUpdateCmd;

public interface IUserService {
    UserVO register(UserRegisterCmd cmd);

    UserVO login(UserLoginQuery query);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    IPage<UserVO> page(UserListByParamQuery query);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    UserVO one(Long id);

    /**
     * 更新
     * @param cmd
     * @return
     */
    UserVO update(UserUpdateCmd cmd);
}
