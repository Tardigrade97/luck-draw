package com.example.lduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lduser.po.Activity;
import com.example.lduser.service.ActivityService;
import com.example.lduser.mapper.ActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author DuanXuYang
* @description 针对表【ld_activity】的数据库操作Service实现
* @createDate 2023-03-09 17:22:48
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{

}




