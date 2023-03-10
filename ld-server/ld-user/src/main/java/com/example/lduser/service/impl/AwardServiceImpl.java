package com.example.lduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lduser.po.Award;
import com.example.lduser.service.AwardService;
import com.example.lduser.mapper.AwardMapper;
import org.springframework.stereotype.Service;

/**
* @author DuanXuYang
* @description 针对表【ld_award】的数据库操作Service实现
* @createDate 2023-03-09 17:22:43
*/
@Service
public class AwardServiceImpl extends ServiceImpl<AwardMapper, Award>
    implements AwardService{

}




