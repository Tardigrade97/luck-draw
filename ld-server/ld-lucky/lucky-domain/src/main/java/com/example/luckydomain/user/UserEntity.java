package com.example.luckydomain.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.alibaba.cola.domain.*;

import java.time.LocalDateTime;


@Entity
@Data
public class UserEntity {

    private Long id;

    /**
     * 账号
     */
    private UserName username;

    /**
     * 密码
     */
    private UserPassword password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     *
     */

    private LocalDateTime createTime;


    /**
     *
     */

    private LocalDateTime updateTime;

}

