package com.example.lduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lduser.po.Record;
import com.example.lduser.service.RecordService;
import com.example.lduser.mapper.RecordMapper;
import org.springframework.stereotype.Service;

/**
* @author DuanXuYang
* @description 针对表【ld_record】的数据库操作Service实现
* @createDate 2023-03-09 17:22:27
*/
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
    implements RecordService{

}




